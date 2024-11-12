package entities;

public class EntryGate {
    int x, y;

    int gateNumber;

    public EntryGate(int _x, int _y, int _gateNumber) {
        this.x = _x;
        this.y = _y;
        this.gateNumber = _gateNumber;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }

}
