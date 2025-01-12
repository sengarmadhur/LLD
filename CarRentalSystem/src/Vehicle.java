public class Vehicle {

    int vehicleId;
    int vehicleNumber;
    VehicleType vehicleType;
    Status status;

    public Vehicle(int id, int number, VehicleType type) {
        vehicleId = id;
        vehicleNumber = number;
        vehicleType = type;
        status = Status.ACTIVE;
    }
}
