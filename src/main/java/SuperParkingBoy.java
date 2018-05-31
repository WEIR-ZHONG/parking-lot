import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SuperParkingBoy extends Parker{
    public SuperParkingBoy(List<ParkingLot> parkinglots, int id) {
        super(parkinglots, id);
    }

    @Override
    public int park(Car car) {
        return Collections.max(parkinglots, Comparator.comparing(ParkingLot::getRemainRate)).park(car);
    }
}
