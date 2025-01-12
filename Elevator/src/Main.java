import java.util.*;

public class Main {
    public static void main(String[] args) {

        ElevatorController elevatorController = new ElevatorController();
        List<InternalButton> internalButtonList = new ArrayList<>();
        for (int i=0; i<10; i++) {
            internalButtonList.add( new InternalButton(i, elevatorController));
        }
        Elevator elevator = new Elevator(3, ElevatorState.IDLE, new Display(3, Direction.IDLE), Direction.IDLE, internalButtonList);
        elevatorController.setElevator(elevator);
        Building building = new Building();
        List<Floor> floors = new ArrayList<>();

        for (int i=0; i<10; i++) {
            floors.add(new Floor(i, new ExternalButton(i, elevatorController)));
        }

        elevatorController.submitRequet(4);
        elevatorController.submitRequet(6);
        elevatorController.submitRequet(2);
        elevator.move();


    }
}