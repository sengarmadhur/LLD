import java.util.*;

public class Topic {
    String topicId;

    List<String>messages;

    int offset;

    public Topic() {
        topicId = UUID.randomUUID().toString();
        offset = 0;
        messages = new ArrayList<>();
    }

    public String getTopicId() {
        return topicId;
    }

    public void addMessage(String message) {
        offset++;
        messages.add(message);
    }
}
