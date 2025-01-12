package model;

import lombok.Getter;
import public_interface.ISubscriber;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class TopicSubscriber {
    private ISubscriber subscriber;
    @Getter
    private final AtomicInteger offset;

    public TopicSubscriber(ISubscriber subscriber) {
        this.subscriber = subscriber;
        this.offset = new AtomicInteger(0);
    }

}
