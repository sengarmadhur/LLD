package entity;

import java.util.List;

public class ParkingFloor {
    List<ParkingSlot> parkingSlots;

    public ParkingFloor(List<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    public void setParkingSlots(List<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }
}
