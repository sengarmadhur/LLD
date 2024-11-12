package entities;

public class ParkingSlot {
    Integer slotId;

    boolean isFree;
    Vehicle vehicle;
    int x,y;

    public int getSlotId() {
        return slotId;
    }

    @Override
    public String toString() {
        return slotId.toString();
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    String slotYpe;

    public String getSlotYpe() {
        return slotYpe;
    }

    public void setSlotYpe(String slotYpe) {
        this.slotYpe = slotYpe;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
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


}
