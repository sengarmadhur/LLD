package service;

import entity.ParkingFloor;
import entity.ParkingLot;
import entity.ParkingSlot;
import entity.Vehicle;
import enums.DisplayType;
import enums.VehicleType;
import repository.ParkingDataRepository;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingLotService {
    HashMap<String, Vehicle> vehicleHashMap;

    ParkingLot parkingLot;

    ParkingDataRepository repository;

    public void createParkingLot(ParkingLot parkingLot) {
        vehicleHashMap = new HashMap<>();
        this.parkingLot = parkingLot;
        repository = new ParkingDataRepository();
        this.parkingLot.setParkingFloors(repository.initializeData(parkingLot.getNoOfFloors(), parkingLot.getNoOfSlotsPerFloor()));
        System.out.println("Created parking lot with " + parkingLot.getNoOfFloors()+
                " floors and " + parkingLot.getNoOfSlotsPerFloor() + " slots per floor");
    }

    public void parkVehicle(VehicleType type, String registrationNumber, String color) {
        ParkingSlot parkingSlot = getFirstAvailableSlot(type);
        if (parkingSlot == null) {
            System.out.println("Parking Lot is full");
        } else {
            parkingSlot.setIsFree(false);
            String ticket = generateTicket(parkingSlot);
            Vehicle  vehicle = new Vehicle(type, registrationNumber, color, parkingSlot, ticket);
            vehicleHashMap.put(ticket, vehicle);
            System.out.println("Parked Vehicle. Ticket ID: " + ticket);
        }
    }

    public void unParkVehicle(String ticketId) {
        if (vehicleHashMap.containsKey(ticketId)) {
            Vehicle vehicle = vehicleHashMap.get(ticketId);
            ParkingSlot parkingSlot = vehicle.getParkingSlot();
            parkingSlot.setIsFree(true);
            parkingLot.getParkingFloors().get(parkingSlot.getFloorId()).getParkingSlots().get(parkingSlot.getSlotId()).setIsFree(true);
            vehicleHashMap.remove(ticketId);
            System.out.println("Unparked vehicle with Registration Number:"+vehicle.getRegistrationNumber()+
                    "and Color:"+ vehicle.getColor());
        } else {
            System.out.println("Invalid Ticket");
        }
    }

    public void display(DisplayType displayType, VehicleType vehicleType) {
        if (displayType == DisplayType.FREE_COUNT) {
            displayFreeCount(vehicleType);
        } else if (displayType == DisplayType.FREE_SLOTS) {
            displayFreeSlots(vehicleType);
        } else if (displayType == DisplayType.OCCUPIED_SLOTS) {
            displayOccupiedSlots(vehicleType);
        } else {
            System.out.println("Invalid Display");
        }
    }

    private ParkingSlot getFirstAvailableSlot(VehicleType type) {
        List<ParkingFloor> parkingFloors = parkingLot.getParkingFloors();

        for (ParkingFloor parkingFloor: parkingFloors) {
            List<ParkingSlot> parkingSlots = parkingFloor.getParkingSlots();
            for (ParkingSlot parkingSlot : parkingSlots) {
                if (parkingSlot.isFree() && parkingSlot.getVehicleType().equals(type)) {
                    return parkingSlot;
                }
            }
        }
        return null;
    }

    private String generateTicket(ParkingSlot parkingSlot) {
        return parkingLot.getParkingLotId() + "_" + (parkingSlot.getFloorId()+1)+"_"+(parkingSlot.getSlotId()+1);
    }

    private void displayFreeCount(VehicleType vehicleType) {
        for (int i=0; i<parkingLot.getNoOfFloors(); i++) {
            ParkingFloor parkingFloor = parkingLot.getParkingFloors().get(i);
            long count = parkingFloor.getParkingSlots().stream()
                    .filter(parkingSlot -> parkingSlot.isFree())
                    .filter(parkingSlot -> parkingSlot.getVehicleType().equals(vehicleType))
                    .count();
            System.out.println("No. of free slots for " + vehicleType + " on Floor " + (i+1) + " : " + count);
        }
    }

    private void displayFreeSlots(VehicleType vehicleType) {
        for (int i=0; i<parkingLot.getNoOfFloors(); i++) {
            ParkingFloor parkingFloor = parkingLot.getParkingFloors().get(i);
            List<ParkingSlot> freeSlots = parkingFloor.getParkingSlots().stream()
                    .filter(parkingSlot -> parkingSlot.isFree())
                    .filter(parkingSlot -> parkingSlot.getVehicleType().equals(vehicleType))
                    .collect(Collectors.toList());
            String freeSlotIds = "";
            for (ParkingSlot parkingSlot: freeSlots) {
                freeSlotIds+=parkingSlot.getSlotId();
                freeSlotIds += ",";
            }
            System.out.println("No. of free slots for " + vehicleType + " on Floor " + (i+1) + " : " + freeSlotIds);
        }
    }

    private void displayOccupiedSlots(VehicleType vehicleType) {
        for (int i=0; i<parkingLot.getNoOfFloors(); i++) {
            ParkingFloor parkingFloor = parkingLot.getParkingFloors().get(i);
            List<ParkingSlot> occupiedSlots = parkingFloor.getParkingSlots().stream()
                    .filter(parkingSlot -> !parkingSlot.isFree())
                    .filter(parkingSlot -> parkingSlot.getVehicleType().equals(vehicleType))
                    .collect(Collectors.toList());
            String occupiedSlotIds = "";
            for (ParkingSlot parkingSlot: occupiedSlots) {
                occupiedSlotIds+=parkingSlot.getSlotId();
                occupiedSlotIds += ",";
            }
            System.out.println("No. of free slots for " + vehicleType + " on Floor " + (i+1) + " : " + occupiedSlotIds);
        }
    }
}
