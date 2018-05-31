import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SmartParkingBoyTest {

    @Test
    public void should_parkingIntoFirstParkingLotWhenFirstParkingLotHaveMostSpace() {
        List<ParkingLot> parkinglots = new ArrayList<>();
        ParkingLot firstParkinLot = new ParkingLot(1, 20);
        parkinglots.add(firstParkinLot);
        ParkingLot secondParkinLot = new ParkingLot(2, 10);
        parkinglots.add(secondParkinLot);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(1, parkinglots);
        Car car = new Car(1);
        int token = smartParkingBoy.park(car);
        assertThat(token).isEqualTo(1);
        assertThat(firstParkinLot.hasCar(1)).isTrue();
        assertThat(secondParkinLot.hasCar(1)).isFalse();
    }

    @Test
    public void should_parkingIntoFirstParkingLotWhenFirstParkingLotHaveEqualSpace() {
        List<ParkingLot> parkinglots = new ArrayList<>();
        ParkingLot firstParkinLot = new ParkingLot(1, 10);
        parkinglots.add(firstParkinLot);
        ParkingLot secondParkinLot = new ParkingLot(2, 10);
        parkinglots.add(secondParkinLot);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(1, parkinglots);
        Car car = new Car(1);
        int token = smartParkingBoy.park(car);
        assertThat(token).isEqualTo(1);
        assertThat(firstParkinLot.hasCar(1)).isTrue();
        assertThat(secondParkinLot.hasCar(1)).isFalse();
    }

    @Test
    public void should_parkingIntoSecondParkingLotWhenSecondParkingLotHaveEqualSpace() {
        List<ParkingLot> parkinglots = new ArrayList<>();
        ParkingLot firstParkinLot = new ParkingLot(1, 5);
        parkinglots.add(firstParkinLot);
        ParkingLot secondParkinLot = new ParkingLot(2, 10);
        parkinglots.add(secondParkinLot);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(1, parkinglots);
        Car car = new Car(1);
        int token = smartParkingBoy.park(car);
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
        SmartParkingBoy parkingBoy = new SmartParkingBoy(1, parkinglots);
        Car car = new Car(1);
        int token = parkingBoy.park(car);
        assertThat(firstParkinLot.hasCar(token)).isTrue();
        assertThat(secondParkinLot.hasCar(token)).isFalse();
        Car getCar = parkingBoy.getCar(token);
        assertThat(getCar).isEqualTo(car);
        assertThat(firstParkinLot.hasCar(token)).isFalse();
        assertThat(secondParkinLot.hasCar(token)).isFalse();
    }

    @Test
    public void should_getCarInSecondParkingLotWhenItHasParkingByCarId() {
        List<ParkingLot> parkinglots = new ArrayList<>();
        ParkingLot firstParkinLot = new ParkingLot(1, 0);
        parkinglots.add(firstParkinLot);
        ParkingLot secondParkinLot = new ParkingLot(2, 10);
        parkinglots.add(secondParkinLot);
        SmartParkingBoy parkingBoy = new SmartParkingBoy(1, parkinglots);
        Car car = new Car(1);
        int token = parkingBoy.park(car);
        assertThat(firstParkinLot.hasCar(token)).isFalse();
        assertThat(secondParkinLot.hasCar(token)).isTrue();
        Car getCar = parkingBoy.getCar(token);
        assertThat(getCar).isEqualTo(car);
        assertThat(firstParkinLot.hasCar(token)).isFalse();
        assertThat(secondParkinLot.hasCar(token)).isFalse();
    }

}
