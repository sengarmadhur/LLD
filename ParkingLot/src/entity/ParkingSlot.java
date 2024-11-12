package entity;

import enums.VehicleType;

public class ParkingSlot {
    int floorId;
    int slotId;
    boolean isFree;
    VehicleType vehicleType;

    public ParkingSlot(int slotId, boolean isFree, VehicleType vehicleType) {
        this.slotId = slotId;
        this.isFree = isFree;
        this.vehicleType = vehicleType;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public void setIsFree(boolean isFree) {
        this.isFree = isFree;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getFloorId() {
        return floorId;
    }

    public int getSlotId() {
        return slotId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public boolean isFree() {
        return isFree;
    }
}
