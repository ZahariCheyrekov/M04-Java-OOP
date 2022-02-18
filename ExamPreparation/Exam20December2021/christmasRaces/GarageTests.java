package garage;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class GarageTests {
    private Garage garage;
    private Car tesla;
    private Car lada;

    @Before
    public void setUp() {
        garage = new Garage();
        tesla = new Car("Tesla", 1000, 60_000);
        lada = new Car("Lada", 80, 400);
    }

    @Test
    public void testShouldAddCarInGarageCorrectly() {
        this.garage.addCar(tesla);
        int expectedCount = 1;
        int actual = this.garage.getCount();
        assertEquals(expectedCount, actual);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testShouldThrowExceptionFoUnmodifiableCollection() {
        this.garage.addCar(this.tesla);
        this.garage.getCars().clear();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForNullCar() {
        this.garage.addCar(null);
    }

    @Test
    public void testShouldFindCarsWithMaxSpeedAboveCertainNumber() {
        this.garage.addCar(this.tesla);
        List<Car> cars = this.garage.findAllCarsWithMaxSpeedAbove(100);
        assertEquals(1, cars.size());
    }

    @Test
    public void testShouldFindTheMostExpensiveCarInTheGarage() {
        garage.addCar(tesla);
        garage.addCar(lada);
        Car mostExpensiveCar = this.garage.getTheMostExpensiveCar();
        assertEquals(tesla, mostExpensiveCar);
    }

    @Test
    public void testShouldFindAllCarsByGivenBrand() {
        garage.addCar(tesla);
        garage.addCar(lada);
        List<Car> carsByBrand = this.garage.findAllCarsByBrand("Tesla");
        Car actual = carsByBrand.get(0);
        assertEquals(tesla, actual);
    }
}