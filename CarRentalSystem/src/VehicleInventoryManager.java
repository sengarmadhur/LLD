import java.util.*;
public class VehicleInventoryManager {

    List<Vehicle> vehicleList;

    public VehicleInventoryManager() {
        vehicleList = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleList.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        for(int i=0; i<vehicleList.size(); i++) {
            if (vehicle.vehicleId == vehicleList.get(i).vehicleId) {
                vehicleList.remove(i);
                break;
            }
        }
    }

    public void reserveVehicle(Vehicle vehicle) {
        vehicle.status = Status.INACTIVE;
        for(int i=0; i<vehicleList.size(); i++) {
            if (vehicle.vehicleId == vehicleList.get(i).vehicleId) {
                vehicleList.remove(i);
                vehicleList.add(vehicle);
                break;
            }
        }
    }

    public void completeReservation(Vehicle vehicle) {
        vehicle.status = Status.ACTIVE;
        for(int i=0; i<vehicleList.size(); i++) {
            if (vehicle.vehicleId == vehicleList.get(i).vehicleId) {
                vehicleList.remove(i);
                vehicleList.add(vehicle);
                break;
            }
        }
    }
}
