import java.util.List;

public class ParkingBoy extends Parker {

    public ParkingBoy(int id, List<ParkingLot> parkinglots) {
        super(parkinglots, id);
    }

    @Override
    public int park(Car car) {
        return parkinglots.stream().filter(parkingLot -> parkingLot.getRemainVolume() > 0).findFirst().map(parkingLot -> parkingLot.park(car)).orElse(0);
    }

}
