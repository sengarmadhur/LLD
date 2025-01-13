import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Topic t1 = new Topic();
        Subscriber s1 = new Subscriber();

        Topic t2 = new Topic();
        Subscriber s2 = new Subscriber();
        Subscriber s3 = new Subscriber();

        MessageQueue q = new MessageQueue();
        q.createTopic(t1);
        q.createTopic(t2);

        q.addSubscriber(t1,s1);
        q.addSubscriber(t1, s2);
        q.addSubscriber(t1, s3);
        q.addSubscriber(t2, s1);
        q.addSubscriber(t2, s2);
        Random random = new Random();
        for (int i=0; i<10; i++) {
            q.publish(t1, "" + random.nextInt(1, 100));
            q.publish(t2, "" + random.nextInt(10000, 10000000));

        }

    }
}