import java.util.*;
public class VehicleRentalSystem {
    List<Store> storeList;

    List<User> userList;

    public VehicleRentalSystem() {
        storeList = new ArrayList<>();
        userList = new ArrayList<>();
    }

    public Store getStore(Location location) {
        for (Store store: storeList) {
            if (store.location.id == location.id) {
                return store;
            }
        }
        return null;
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public void addStore(Store store) {
        storeList.add(store);
    }
}
