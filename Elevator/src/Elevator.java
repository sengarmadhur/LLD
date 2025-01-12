import java.util.*;

public class Elevator {
    int id;
    int currentFloor;
    ElevatorState currentState;
    Display display;
    Direction direction;
    List<InternalButton> internalButtons;

    PriorityQueue<Request> upQueue;

    PriorityQueue<Request> downQueue;

    Elevator(int floor, ElevatorState state, Display display, Direction direction, List<InternalButton> internalButtonsList) {
        internalButtons = new ArrayList<>();
        this.currentFloor = floor;
        this.currentState = state;
        this.direction = direction;

        upQueue = new PriorityQueue<Request>((a,b) -> a.desiredFloor - b.desiredFloor);
        downQueue = new PriorityQueue<Request>((a, b) -> b.desiredFloor - a.desiredFloor);
    }
    private void processUpRequest() {
        while (!upQueue.isEmpty()) {
            Request request = upQueue.poll();
            this.currentFloor = request.currentFloor;
            System.out.println("Processing UP request, elevator stopped at " + this.currentFloor);
            System.out.println("Elevator reached at floor " + request.desiredFloor);
        }

        if (!downQueue.isEmpty()) {
            this.direction = Direction.DOWN;
        } else {
            this.direction = Direction.IDLE;
        }
    }

    private void processDownRequest() {
        while (!downQueue.isEmpty()) {
            Request request = downQueue.poll();
            this.currentFloor = request.currentFloor;
            System.out.println("Processing Down request, elevator stopped at " + this.currentFloor);
        }

        if (!upQueue.isEmpty()) {
            this.direction = Direction.UP;
        } else {
            this.direction = Direction.IDLE;
        }
    }

    public void acceptRequest(Request request) {
        if (request.direction == Direction.UP) {
            upQueue.offer(request);
        } else {
            downQueue.offer(request);
        }
    }

    public void move() {
        while (!upQueue.isEmpty() || !downQueue.isEmpty()) {
            if (this.direction == Direction.IDLE || this.direction == Direction.UP) {
                processUpRequest();
                processDownRequest();
            } else {
                processDownRequest();
                processUpRequest();
            }
        }
        this.direction = Direction.IDLE;
    }
}
