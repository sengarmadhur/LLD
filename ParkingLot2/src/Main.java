import entities.EntryGate;
import entities.ParkingSlot;
import entities.Vehicle;
import repository.ParkingRepository;
import service.ParkingService;
import service.PaymentService;

public class Main {
    public static void main(String[] args) {
        ParkingRepository parkingRepository = new ParkingRepository();
        ParkingService parkingService = new ParkingService();
        PaymentService paymentService = new PaymentService();
        parkingService.setParkingRepository(parkingRepository);
        parkingService.setPaymentService(paymentService);

        parkingService.createParkingLot(5, 2);
        parkingService.checkAvailability();

        parkingService.parkVehicle(new Vehicle("Car", "AP09VT5001"), new EntryGate(3, 22, 1));
        parkingService.parkVehicle(new Vehicle("Car", "AP09VT5002"), new EntryGate(3, 34, 2));
        parkingService.parkVehicle(new Vehicle("Car", "AP09VT5003"), new EntryGate(3, 19, 3));
        parkingService.parkVehicle(new Vehicle("Bike", "AP09VT5004"), new EntryGate(3, 22, 1));
        parkingService.parkVehicle(new Vehicle("Bike", "AP09VT5005"), new EntryGate(3, 22, 2));

        parkingService.parkVehicle(new Vehicle("Car", "AP09VT5006"), new EntryGate(3, 22, 1));

        parkingService.removeVehicle(new Vehicle("Car", "AP09VT5001"));

        parkingService.checkAvailability();

    }
}