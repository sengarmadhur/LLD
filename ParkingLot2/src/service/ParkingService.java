package service;

import entities.EntryGate;
import entities.ParkingSlot;
import entities.Ticket;
import entities.Vehicle;
import repository.ParkingRepository;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ParkingService {
    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(List<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    public PaymentService getPaymentService() {
        return paymentService;
    }

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public ParkingRepository getParkingRepository() {
        return parkingRepository;
    }

    public void setParkingRepository(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    List<ParkingSlot> parkingSlots;

    PaymentService paymentService;

    ParkingRepository parkingRepository;
    Map<String, Ticket> ticketVehicleMap = new HashMap<>();

    public  void createParkingLot(int n, int m) {
        this.parkingSlots = parkingRepository.initialize(n,m);
        System.out.println(parkingSlots.size());
        System.out.println(parkingSlots.get(0).getSlotYpe());
        System.out.println("Created parking lot");
    }

    public  void parkVehicle(Vehicle vehicle, EntryGate gate) {
        ParkingSlot slot = null;
        for( ParkingSlot parkingSlot: parkingSlots) {
            if (parkingSlot.isFree() && parkingSlot.getSlotYpe().equals(vehicle.getType())) {
                if (Objects.isNull(slot) || (getDist(gate, parkingSlot) <= getDist(gate, slot))) {
                    slot = parkingSlot;
                }
            }
        }

        if (Objects.isNull(slot)) {
            System.out.println("Parking is full for vehicle of type: " + vehicle.getType());
            return;
        }

        Ticket ticket = new Ticket();
        ticket.setVehicle(vehicle);
        ticket.setEntryGate(gate);
        ticket.setTimeStamp(new Timestamp(System.currentTimeMillis()));
        ticket.setTicketId(vehicle.getNumber() + gate.getGateNumber());
        ticket.setParkingSlot(slot);
        parkingSlots.get(slot.getSlotId()).setVehicle(vehicle);
        parkingSlots.get(slot.getSlotId()).setFree(false);
        ticketVehicleMap.put(vehicle.getNumber(), ticket);

        System.out.println("Parket Car Ticket: " + ticket.toString());
    }

    public  void removeVehicle(Vehicle vehicle) {
        if (!ticketVehicleMap.containsKey(vehicle.getNumber())) {
            System.out.println("Vehicle not present in parking");
        }

        Ticket ticket = ticketVehicleMap.get(vehicle.getNumber());
        paymentService.pay(ticket.getTimeStamp(), new Timestamp(System.currentTimeMillis()));

        parkingSlots.get(ticket.getParkingSlot().getSlotId()).setFree(true);
        parkingSlots.get(ticket.getParkingSlot().getSlotId()).setVehicle(null);
    }

    public  void checkAvailability() {
        for (ParkingSlot slot: parkingSlots) {
            System.out.println(slot.getSlotId() + " isFree? " + slot.isFree());
        }
    }

    private int getDist(EntryGate gate, ParkingSlot parkingSlot) {
        return Math.abs(gate.getX() - parkingSlot.getX()) + Math.abs(gate.getY() - parkingSlot.getY());
    }
}
