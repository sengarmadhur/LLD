public class InternalButton {
    int number;
    ElevatorController controller;

    public InternalButton(int num, ElevatorController controller) {
        this.number = num;
        this.controller = controller;
    }
    public void pressButton() {
        controller.submitRequet(number);
    }
}
