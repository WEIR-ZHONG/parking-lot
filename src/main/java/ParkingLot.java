import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ParkingLot {
    private final int volume;
    private final int id;
    private List<Car> cars = new ArrayList<>();

    public ParkingLot(int id, int volume) {
        this.id = id;
        this.volume = volume;
    }

    public boolean hasCar(int carId) {
        return getCarIndex(carId) >= 0;
    }
    public int park(Car car) {

        cars.add(car);
        return car.getId();
    }

    public double getRemainVolume() {
        return volume - cars.size();
    }

    public Car getCar(int token) {
        int index = getCarIndex(token);
        if(index >= 0) {
            Car result = cars.get(index);
            cars.remove(result);
            return result;
        } else {
            return null;
        }
    }

    private int getCarIndex(int carId) {
        return IntStream.range(0, cars.size()).filter(i -> cars.get(i).getId() == carId).findFirst().orElse(-1);
    }

    public double getRemainRate() {
        return getRemainVolume() / volume;
    }
}
