import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy extends Parker{

    public SmartParkingBoy(int id, List<ParkingLot> parkinglots) {
        super(parkinglots, id);
    }

    @Override
    public int park(Car car) {
        return Collections.max(parkinglots, Comparator.comparing(ParkingLot::getRemainVolume)).park(car);
    }
}
