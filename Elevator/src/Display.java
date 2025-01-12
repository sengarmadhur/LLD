
public class Display {
    int floorNumber;
    Direction direction;

    public Display(int num, Direction direction) {
        this.direction = direction;
        this.floorNumber = num;
    }

    public void setDisplay(int floorNumber, Direction direction) {
        this.floorNumber = floorNumber;
        this.direction = direction;
    }

    public void showDisplay() {
        System.out.println(floorNumber);
        System.out.println(direction);
    }
}
