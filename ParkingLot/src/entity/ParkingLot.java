package entity;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    String parkingLotId;
    int noOfFloors;
    int noOfSlotsPerFloor;

    List<ParkingFloor> parkingFloors;

    public ParkingLot(String parkingLotId, int noOfFloors, int noOfSlotsPerFloor) {
        this.noOfFloors = noOfFloors;
        this.noOfSlotsPerFloor = noOfSlotsPerFloor;
        this.parkingLotId = parkingLotId;
        parkingFloors = new ArrayList<>(noOfFloors);
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setNoOfFloors(int noOfFloors) {
        this.noOfFloors = noOfFloors;
    }

    public void setNoOfSlotsPerFloor(int noOfSlotsPerFloor) {
        this.noOfSlotsPerFloor = noOfSlotsPerFloor;
    }

    public int getNoOfSlotsPerFloor() {
        return noOfSlotsPerFloor;
    }

    public int getNoOfFloors() {
        return noOfFloors;
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }
}
