import java.util.*;

public class Store {
    int storeId;
    VehicleInventoryManager manager;
    Location location;

    PaymentHandler paymentHandler;

    List<Reservation> reservationList;

    public Store(VehicleInventoryManager manager, Location location, PaymentHandler paymentHandler) {
        reservationList = new ArrayList<>();
        Random random = new Random();
        storeId = random.nextInt();
        this.manager = manager;
        this.location = location;
        this.paymentHandler = paymentHandler;
    }

    public List<Vehicle> getVehicle() {
        return manager.vehicleList;
    }

    public Bill reserveVehicle(Reservation reservation) {
        manager.reserveVehicle(reservation.vehicle);
        Bill bill = new Bill();
        bill.amount = 300*(reservation.endDate - reservation.startDate);
        bill.reservation = reservation;
        bill.isPaid = false;
        reservationList.add(reservation);
        return bill;
    }

    public void completereservation(Reservation reservation) {
        manager.completeReservation(reservation.vehicle);
    }

    public void payBill(Bill bill) {
        paymentHandler.pay(bill);
    }

    public void addVehicle(Vehicle vehicle) {
        manager.addVehicle(vehicle);
    }
}
