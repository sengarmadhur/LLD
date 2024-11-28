public class Player {
    String id;
    int currentPosition;

    public Player(String name, int pos) {
        id = name;
        currentPosition = pos;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}
