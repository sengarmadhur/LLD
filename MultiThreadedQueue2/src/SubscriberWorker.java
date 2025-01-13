/*
Two synchronized block on same objects can call wait and notif of different threads
* */


import java.util.Objects;

public class SubscriberWorker implements Runnable {
    Subscriber subscriber;
    Topic topic;

    int offset;

    public SubscriberWorker(Topic t, Subscriber s) {
        this.subscriber = s;
        this.topic = t;
        offset = t.offset;
    }

    @Override
    public void run() {

        synchronized (this) {
            do {
                while (offset == topic.offset) {
                    try {
                        System.out.println("Putting thread on wait: " + Thread.currentThread().getName());
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                while (offset < topic.offset) {
                    subscriber.consume(topic.messages.get(offset));
                    offset++;
                }
            } while (true);
        }
    }


    public synchronized void wakeUp() {
        synchronized (this) {
            notify();
        }
    }
}
