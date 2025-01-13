import java.util.*;

public class MessageQueue {

    Map<String, TopicHandler> topicHandlerMap;

    MessageQueue() {
        topicHandlerMap = new HashMap<>();
    }
    public void createTopic(Topic topic) {
        if (topicHandlerMap.containsKey(topic.getTopicId())) {
            System.out.println("Topic already exist");
            return;
        }

        TopicHandler topicHandler = new TopicHandler(topic);
        topicHandlerMap.put(topic.getTopicId(), topicHandler);
    }

    public void publish(Topic topic, String message) {
        TopicHandler topicHandler = topicHandlerMap.get(topic.getTopicId());
        topicHandler.publish(message);
    }

    public void addSubscriber(Topic t, Subscriber s) {
        TopicHandler topicHandler = topicHandlerMap.get(t.getTopicId());
        topicHandler.addSubscriber(s);
    }
}
