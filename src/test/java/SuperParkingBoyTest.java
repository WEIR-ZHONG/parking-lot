import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SuperParkingBoyTest {

    @Test
    public void should_parkingIntoSecondParkingLotWhenSecondCar() {
        List<ParkingLot> parkinglots = new ArrayList<>();
        ParkingLot firstParkinLot = new ParkingLot(1, 20);
        parkinglots.add(firstParkinLot);
        ParkingLot secondParkinLot = new ParkingLot(2, 10);
        parkinglots.add(secondParkinLot);
        SuperParkingBoy parkingBoy = new SuperParkingBoy(parkinglots, 1);
        Car car1 = new Car(1);
        int token1 = parkingBoy .park(car1);
        assertThat(token1).isEqualTo(1);
        assertThat(firstParkinLot.hasCar(1)).isTrue();
        assertThat(secondParkinLot.hasCar(1)).isFalse();

        Car car2 = new Car(2);
        int token2 = parkingBoy .park(car2);
        assertThat(token2).isEqualTo(2);
        assertThat(firstParkinLot.hasCar(2)).isFalse();
        assertThat(secondParkinLot.hasCar(2)).isTrue();
    }

    @Test
    public void should_parkingIntoFirstParkingLotWhenFirstRemainRateIsLess() {
        List<ParkingLot> parkinglots = new ArrayList<>();
        ParkingLot firstParkinLot = new ParkingLot(1, 10);
        parkinglots.add(firstParkinLot);
        ParkingLot secondParkinLot = new ParkingLot(2, 20);
        parkinglots.add(secondParkinLot);
        SuperParkingBoy parkingBoy = new SuperParkingBoy(parkinglots, 1);
        for(int i = 0;i<5;i++) {
            Car car = new Car(i);
            firstParkinLot.park(car);
        }
        for(int i = 0;i<11;i++) {
            Car car = new Car(i+5);
            secondParkinLot.park(car);
        }
        Car car2 = new Car(20);
        int token2 = parkingBoy .park(car2);
        assertThat(token2).isEqualTo(20);
        assertThat(firstParkinLot.hasCar(20)).isTrue();
        assertThat(secondParkinLot.hasCar(20)).isFalse();
    }

    @Test
    public void should_getCarWhenItHasParkingByCarId() {
        List<ParkingLot> parkinglots = new ArrayList<>();
        ParkingLot firstParkinLot = new ParkingLot(1, 10);
        parkinglots.add(firstParkinLot);
        ParkingLot secondParkinLot = new ParkingLot(2, 10);
        parkinglots.add(secondParkinLot);
        SuperParkingBoy parkingBoy = new SuperParkingBoy(parkinglots,1);
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
        ParkingLot firstParkinLot = new ParkingLot(1, 20);
        parkinglots.add(firstParkinLot);
        ParkingLot secondParkinLot = new ParkingLot(2, 10);
        parkinglots.add(secondParkinLot);
        SuperParkingBoy parkingBoy = new SuperParkingBoy(parkinglots, 1);
        Car car1 = new Car(1);
        int token1 = parkingBoy .park(car1);
        assertThat(token1).isEqualTo(1);
        assertThat(firstParkinLot.hasCar(1)).isTrue();
        assertThat(secondParkinLot.hasCar(1)).isFalse();

        Car car2 = new Car(2);
        int token2 = parkingBoy .park(car2);
        assertThat(token2).isEqualTo(2);
        assertThat(firstParkinLot.hasCar(2)).isFalse();
        assertThat(secondParkinLot.hasCar(2)).isTrue();

        Car result = parkingBoy.getCar(2);
        assertThat(result).isEqualTo(car2);
        assertThat(firstParkinLot.hasCar(2)).isFalse();
        assertThat(secondParkinLot.hasCar(2)).isFalse();

    }
}
