package handler;

import lombok.Getter;
import model.Topic;
import model.TopicSubscriber;

import java.util.HashMap;
import java.util.Map;

@Getter
public class TopicHandler {

    private Topic topic;
    private Map<String, SubscriberWorker> subscriberWorkers;

    public TopicHandler(Topic topic) {
        this.topic = topic;
        subscriberWorkers = new HashMap<>();
    }

    public void publish() {
        for (TopicSubscriber topicSubscriber: topic.getSubscribers()) {
            startSubscriberWorker(topicSubscriber);
        }
    }

   public void startSubscriberWorker(TopicSubscriber topicSubscriber) {
        String subscriberId = topicSubscriber.getSubscriber().getId();
        if (!subscriberWorkers.containsKey(subscriberId)) {
            SubscriberWorker subscriberWorker = new SubscriberWorker(topic, topicSubscriber);
            subscriberWorkers.put(subscriberId, subscriberWorker);
            new Thread(subscriberWorker).start();
        }

        SubscriberWorker subscriberWorker = subscriberWorkers.get(subscriberId);
        subscriberWorker.wakeUpIfNeeded();
   }
}
