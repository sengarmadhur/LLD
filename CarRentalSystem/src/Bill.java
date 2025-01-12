public class Bill {
    Reservation reservation;
    boolean isPaid;
    int amount;

    public String toString() {
        return reservation.toString() + " Amount:" + amount + " paymentStatus:" + isPaid;
    }
}
