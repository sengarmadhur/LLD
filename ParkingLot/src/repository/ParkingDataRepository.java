package repository;

import entity.ParkingFloor;
import entity.ParkingSlot;
import enums.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class ParkingDataRepository {

    List<ParkingSlot> parkingSlotData;
    List<ParkingFloor> parkingFloorData;

    public List<ParkingFloor> initializeData(int noOfFloors, int noOfSlots) {
        parkingFloorData = new ArrayList<>(noOfFloors);

        for (int i=0; i<noOfFloors; i++) {
            initializeSlots(noOfSlots);
            List<ParkingSlot> parkingSlots = getAllParkingSlotData(i);
            parkingFloorData.add(new ParkingFloor(parkingSlots));
        }
        return parkingFloorData;
    }

    public  void initializeSlots(int noOfSlots) {
        parkingSlotData = new ArrayList<>(noOfSlots);

        if (noOfSlots >= 1) {
            parkingSlotData.add(getTruckData(0));
        }
        if (noOfSlots >= 3) {
            for (int i=1;i<3; i++) {
                parkingSlotData.add(getBikeData(i));
            }
        }
        if (noOfSlots > 3) {
            for (int i=3; i<noOfSlots; i++) {
                parkingSlotData.add(getCarData(i));
            }
        }
    }

    public List<ParkingSlot> getAllParkingSlotData(int floorId) {
        parkingSlotData.forEach(parkingSlot -> parkingSlot.setFloorId(floorId));
        return parkingSlotData;
    }

    private ParkingSlot getTruckData(int slotId){return new ParkingSlot(slotId, true, VehicleType.TRUCK);}
    private ParkingSlot getBikeData(int slotId){return new ParkingSlot(slotId, true, VehicleType.BIKE);}
    private ParkingSlot getCarData(int slotId){return new ParkingSlot(slotId, true, VehicleType.CAR);}
}
