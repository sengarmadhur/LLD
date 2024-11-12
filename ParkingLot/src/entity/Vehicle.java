package entity;

import enums.VehicleType;

public class Vehicle {
    VehicleType type;
    String registrationNumber;
    String color;
    ParkingSlot parkingSlot;
    String ticketId;

    public Vehicle(VehicleType type, String registrationNumber, String color, ParkingSlot parkingSlot, String ticketId) {
        this.color = color;
        this.parkingSlot = parkingSlot;
        this.type = type;
        this.ticketId = ticketId;
        this.registrationNumber = registrationNumber;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public VehicleType getType() {
        return type;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketId() {
        return ticketId;
    }
}
