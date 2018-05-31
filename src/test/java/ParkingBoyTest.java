import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ParkingBoyTest {
    @Test
    public void should_parkingIntoFirstParkingLotWhenFirstParkingLotHaveSpace() {
        List<ParkingLot> parkinglots = new ArrayList<>();
        ParkingLot firstParkinLot = new ParkingLot(1, 10);
        parkinglots.add(firstParkinLot);
        ParkingLot secondParkinLot = new ParkingLot(2, 10);
        parkinglots.add(secondParkinLot);
        ParkingBoy parkingBoy = new ParkingBoy(1, parkinglots);
        Car car = new Car(1);
        int token = parkingBoy.park(car);
        assertThat(token).isEqualTo(1);
        assertThat(firstParkinLot.hasCar(1)).isTrue();
    }

    @Test
    public void should_parkingIntosecondParkingLotWhenFirstParkingLotHaveNoSpace() {
        List<ParkingLot> parkinglots = new ArrayList<>();
        ParkingLot firstParkinLot = new ParkingLot(1, 0);
        parkinglots.add(firstParkinLot);
        ParkingLot secondParkinLot = new ParkingLot(2, 10);
        parkinglots.add(secondParkinLot);
        ParkingBoy parkingBoy = new ParkingBoy(1, parkinglots);
        Car car = new Car(1);
        int token = parkingBoy.park(car);
        assertThat(token).isEqualTo(1);
        assertThat(firstParkinLot.hasCar(1)).isFalse();
        assertThat(secondParkinLot.hasCar(1)).isTrue();
    }

    @Test
    public void should_getCarWhenItHasParkingByCarId() {
        List<ParkingLot> parkinglots = new ArrayList<>();
        ParkingLot firstParkinLot = new ParkingLot(1, 10);
        parkinglots.add(firstParkinLot);
        ParkingLot secondParkinLot = new ParkingLot(2, 10);
        parkinglots.add(secondParkinLot);
        ParkingBoy parkingBoy = new ParkingBoy(1, parkinglots);
        Car car = new Car(1);
        int token = parkingBoy.park(car);
        Car getCar = parkingBoy.getCar(token);
        assertThat(getCar).isEqualTo(car);
    }

    @Test
    public void should_getCarInSecondParkingLotWhenItHasParkingByCarId() {
        List<ParkingLot> parkinglots = new ArrayList<>();
        ParkingLot firstParkinLot = new ParkingLot(1, 0);
        parkinglots.add(firstParkinLot);
        ParkingLot secondParkinLot = new ParkingLot(2, 10);
        parkinglots.add(secondParkinLot);
        ParkingBoy parkingBoy = new ParkingBoy(1, parkinglots);
        Car car = new Car(1);
        int token = parkingBoy.park(car);
        Car getCar = parkingBoy.getCar(token);
        assertThat(getCar).isEqualTo(car);
    }

}
