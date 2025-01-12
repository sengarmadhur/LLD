public class ExternalButton {
    int floorId;
    ElevatorController controller;

    public ExternalButton(int floorId, ElevatorController controller) {
        this.floorId = floorId;
        this.controller = controller;
    }
    public void pressButton() {
        controller.submitRequet(this.floorId);
    }
}
