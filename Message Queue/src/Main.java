/*
We have to design a message queue supporting publisher-subscriber model. It should support following operations:

It should support multiple topics where messages can be published.
Publisher should be able to publish a message to a particular topic.
Subscribers should be able to subscribe to a topic.
Whenever a message is published to a topic, all the subscribers, who are subscribed to that topic, should receive the message.
Subscribers should be able to run in parallel


APIs supported in queue
createTopic(topicName) -> topicId
subscribe(topicId, subscriber) -> boolean
publish(topicId, message) -> boolean
readOffset(topidId, subscriber, offset) -> boolean

*/


import model.Message;
import model.Topic;
import public_interface.Queue;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Queue queue = new Queue();
        Topic topic1 = queue.createtopic("T1");
        Topic topic2 = queue.createtopic("T2");
        Topic topic3 = queue.createtopic("T3");

        SleepingSubscriber subscriber1 = new SleepingSubscriber("sub1", 10000);
        SleepingSubscriber subscriber2 = new SleepingSubscriber("sub2", 10000);

        queue.subscribe(subscriber1, topic1);
        queue.subscribe(subscriber2, topic2);

        SleepingSubscriber subscriber3 = new SleepingSubscriber("sub3", 5000);
        queue.subscribe(subscriber3, topic2);

        queue.publish(topic1, new Message("M1"));
        queue.publish(topic2, new Message("M2"));

        queue.publish(topic2, new Message("M3"));

        Thread.sleep(15000);
        queue.publish(topic2, new Message("m4"));
        queue.publish(topic1, new Message("m5"));

        queue.resetOffSet(topic1, subscriber1, 0);

    }
}