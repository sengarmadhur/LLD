package public_interface;

import handler.TopicHandler;
import model.Message;
import model.Topic;
import model.TopicSubscriber;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Queue {

    private final Map<String, TopicHandler> topicHandlerMap;

    public Queue() {
        this.topicHandlerMap = new HashMap<>();
    }

    public Topic createtopic(final String topicName) {
        Topic topic = new Topic(topicName, UUID.randomUUID().toString());
        TopicHandler topicHandler = new TopicHandler(topic);
        topicHandlerMap.put(topic.getTopicId(), topicHandler);
        System.out.println("Created Topic: " + topicName);
        return topic;
    }

    public void subscribe(ISubscriber subscriber, Topic topic) {
        topic.addSubscriber(new TopicSubscriber(subscriber));
        System.out.println(subscriber.getId() + " subscribed to topic: " + topic.getTopicName());
    }

    public void publish(Topic topic, Message message) {
        topic.addMessage(message);
        System.out.println(message.getMsg() + " published message to topic: " + topic.getTopicName());
        new Thread(() -> topicHandlerMap.get(topic.getTopicId()).publish()).start();
    }

    public void resetOffSet(Topic topic, ISubscriber subscriber, Integer newOffset) {
        for (TopicSubscriber topicSubscriber: topic.getSubscribers()) {
            if (topicSubscriber.getSubscriber().equals(subscriber)) {
                topicSubscriber.getOffset().set(newOffset);
                System.out.println(topicSubscriber.getSubscriber().getId() + " offset reset to: " + newOffset);
                new Thread(() -> topicHandlerMap.get(topic.getTopicId()).startSubscriberWorker(topicSubscriber)).start();
                break;
            }
        }
    }
}
