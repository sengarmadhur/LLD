package entities;

import java.sql.Timestamp;

import java.sql.Timestamp;

public class Ticket {
    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public EntryGate getEntryGate() {
        return entryGate;
    }


    @Override
    public String toString() {
        return this.ticketId + "_" + this.entryGate.getGateNumber() + "_" + "_" +this.parkingSlot.toString();
    }

    public void setEntryGate(EntryGate entryGate) {
        this.entryGate = entryGate;
    }

    String ticketId;
    Timestamp timeStamp;

    Vehicle vehicle;
    EntryGate entryGate;

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    ParkingSlot parkingSlot;
}
