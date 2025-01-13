import java.util.*;
public class TopicHandler {
    Topic topic;

    Map<String, SubscriberWorker>  subscriberWorkerMap;

    public TopicHandler(Topic topic) {
        this.topic = topic;
        subscriberWorkerMap = new HashMap<>();
    }

    public void publish(String message) {
        topic.addMessage(message);
        for (Map.Entry<String, SubscriberWorker> entry: subscriberWorkerMap.entrySet()) {
            entry.getValue().wakeUp();
        }
    }

    public void addSubscriber(Subscriber subscriber) {
        if (subscriberWorkerMap.containsKey(subscriber.getSubscriberId())) {
            System.out.println("Subscriber already present");
            return;
        }

        SubscriberWorker subscriberWorker = new SubscriberWorker(topic, subscriber);
        subscriberWorkerMap.put(subscriber.subscriberId, subscriberWorker);
        Thread t1 = new Thread(subscriberWorker);
        t1.start();
    }
}
