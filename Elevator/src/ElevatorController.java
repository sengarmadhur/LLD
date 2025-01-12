public class ElevatorController {
    Elevator elevator;

    public void setElevator(Elevator elevator) {
        this.elevator = elevator;
    }
    public void submitRequet(int number) {
        Request request = new Request(elevator.currentFloor, number, elevator.currentFloor > number ? Direction.DOWN: Direction.UP);
        System.out.println(request.toString());
        elevator.acceptRequest(request);
    }
}
