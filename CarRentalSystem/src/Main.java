public class Main {
    public static void main(String[] args) {

        VehicleRentalSystem vehicleRentalSystem = new VehicleRentalSystem();

        User user = new User(1, "L23DL4");
        User user1 = new User(2, "GK45D3");

        Location location1 = new Location(1, "IndusCrest");
        VehicleInventoryManager manager1 = new VehicleInventoryManager();
        Store store1 = new Store(manager1, location1, new PaymentHandler());

        Location location2 = new Location(2, "Prestige");
        VehicleInventoryManager manager2 = new VehicleInventoryManager();
        Store store2 = new Store(manager2, location2, new PaymentHandler());

        Vehicle vehicl1 = new Vehicle(1, 1231, VehicleType.CAR);
        Vehicle vehicl2 = new Vehicle(2, 1232, VehicleType.CAR);
        Vehicle vehicl3 = new Vehicle(3, 1233, VehicleType.CAR);
        Vehicle vehicl4 = new Vehicle(4, 1234, VehicleType.CAR);
        Vehicle vehicl5 = new Vehicle(5, 1235, VehicleType.CAR);

        vehicleRentalSystem.addStore(store1);
        vehicleRentalSystem.addStore(store2);

        vehicleRentalSystem.addUser(user);
        vehicleRentalSystem.addUser(user1);

        store1.addVehicle(vehicl1);
        store1.addVehicle(vehicl2);

        store2.addVehicle(vehicl3);
        store2.addVehicle(vehicl4);
        store2.addVehicle(vehicl5);


        Store store = vehicleRentalSystem.getStore(location2);

        Reservation reservation = new Reservation();
        reservation.user = user1;
        reservation.startDate = 5;
        reservation.endDate = 7;
        reservation.bookingDate = 1;
        reservation.vehicle = store.getVehicle().get(1);
        Bill bill = store.reserveVehicle(reservation);
        System.out.println(bill.toString());

        store.payBill(bill);

    }
}