import java.util.UUID;

public class Subscriber {
    String subscriberId;

    public Subscriber() {
        subscriberId = UUID.randomUUID().toString();
    }

    public String getSubscriberId() {
        return subscriberId;
    }

    public void consume(String msg) {
        System.out.println("Message consumed: " + msg + " by " + subscriberId);
    }
}
