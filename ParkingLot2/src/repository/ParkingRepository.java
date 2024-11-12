package repository;

import entities.ParkingSlot;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParkingRepository {

    List<ParkingSlot> parkingSlotList;

    Random random = new Random();

    public List<ParkingSlot> initialize(int n, int m) {
        parkingSlotList = new ArrayList<>();

        for (int i=0; i<n; i++) {
            ParkingSlot parkingSlot = new ParkingSlot();
            parkingSlot.setSlotId(i);
            parkingSlot.setFree(true);
            parkingSlot.setX(random.nextInt(100));
            parkingSlot.setY(random.nextInt(100));
            if (i<m) {
                parkingSlot.setSlotYpe("Bike");

            } else {
                parkingSlot.setSlotYpe("Car");
            }
            parkingSlotList.add(parkingSlot);

        }
        return parkingSlotList;
    }
}
