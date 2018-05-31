import java.util.List;

public abstract class Parker {
    protected final int id;
    protected final List<ParkingLot> parkinglots;

    public Parker(List<ParkingLot> parkinglots, int id) {
        this.parkinglots = parkinglots;
        this.id = id;
    }

    public abstract int park(Car car);


    public Car getCar(int token) {
        return parkinglots.stream().filter(parkingLot -> parkingLot.hasCar(token)).findFirst().map(parkingLot -> parkingLot.getCar(token)).orElse(null);
    }
}
