public class Request {
    int currentFloor;
    int desiredFloor;
    Direction direction;

    public Request(int currentFloor, int desiredFloor, Direction direction) {
        this.currentFloor = currentFloor;
        this.direction = direction;
        this.desiredFloor = desiredFloor;
    }

    @Override
    public String toString() {
        return currentFloor + " to " + desiredFloor + " dir:" + direction;
    }

}
