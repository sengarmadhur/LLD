package handler;

import lombok.SneakyThrows;
import model.Message;
import model.Topic;
import model.TopicSubscriber;

public class SubscriberWorker implements Runnable {
    Topic topic;
    TopicSubscriber topicSubscriber;

    public SubscriberWorker(Topic topic, TopicSubscriber topicSubscriber) {
        this.topicSubscriber = topicSubscriber;
        this.topic = topic;
    }

    @SneakyThrows
    @Override
    public void run() {
        synchronized (topicSubscriber) {
            do {
                int currOffset = topicSubscriber.getOffset().get();
                while(currOffset >= topic.getMessages().size()) {
                    wait();
                }

                Message message = topic.getMessages().get(currOffset);
                topicSubscriber.getSubscriber().consume(message);
                topicSubscriber.getOffset().compareAndSet(currOffset, currOffset + 1);
            } while(true);
        }
    }

    synchronized public void wakeUpIfNeeded() {
        synchronized (topicSubscriber) {
            topicSubscriber.notify();
        }
    }
}
