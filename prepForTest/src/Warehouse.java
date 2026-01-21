import java.util.ArrayList;
import java.util.List;

public class Warehouse<T extends BaseRobot> {
    private List<T> storage = new ArrayList<>();

    public void store(T item) throws WarehouseFullException {
        if(item == null) {
            throw new IllegalArgumentException("No item to store");
        }
        if (storage.size() >= 3) {
            throw new WarehouseFullException("The warehouse is full.");
        }
        storage.add(item);
    }

    public T getRobotBySN(String sn) {
        for (T item : storage) {
            if(item.getSerialNumber().equals(sn)) {
                return item;
            }
        }
        return null;
    }
}
