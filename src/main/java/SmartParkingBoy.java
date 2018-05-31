import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy {

    private final int id;
    private final List<ParkingLot> parkinglots;

    public SmartParkingBoy(int id, List<ParkingLot> parkinglots) {

        this.id = id;
        this.parkinglots = parkinglots;
    }

    public int getId() {
        return id;
    }

    public List<ParkingLot> getParkinglots() {
        return parkinglots;
    }

    public int park(Car car) {
        return Collections.max(parkinglots, Comparator.comparing(ParkingLot::getRemainVolume)).park(car);
    }

    public Car getCar(int token) {
        return parkinglots.stream().filter(parkingLot -> parkingLot.hasCar(token)).findFirst().map(parkingLot -> parkingLot.getCar(token)).orElse(null);
    }
}
