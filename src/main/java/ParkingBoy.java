import java.util.List;

public class ParkingBoy {
    private final int id;
    private final List<ParkingLot> parkinglots;

    public ParkingBoy(int id, List<ParkingLot> parkinglots) {
        this.id = id;
        this.parkinglots = parkinglots;
    }

    public int park(Car car) {
        return parkinglots.stream().filter(parkingLot -> parkingLot.getRemainVolume() > 0).findFirst().map(parkingLot -> parkingLot.park(car)).orElse(0);
    }

    public int getId() {
        return id;
    }

    public List<ParkingLot> getParkinglots() {
        return parkinglots;
    }

    public Car getCar(int token) {
        return parkinglots.stream().filter(parkingLot -> parkingLot.hasCar(token)).findFirst().map(parkingLot -> parkingLot.getCar(token)).orElse(null);
//        return getParkinglots().get(0).getCar(token);
    }
}
