package garage;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class GarageTests {

    private Garage garage;
    private Car lamborghini;
    private final static Car SLOW_CAR = new Car("slow", 50, 100);
    private final static Car NULL_CAR = null;
    private static final String CAR_BRAND = "Lamborghini";
    private static final int SPEED = 500;
    private static final int CARS_IN_GARAGE = 2;
    private static final int INDEX = 0;

    @Before
    public void setUp() {
        garage = new Garage();
        lamborghini = new Car("Lamborghini", 1000, 100_000);
        garage.addCar(lamborghini);
        garage.addCar(SLOW_CAR);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testShouldThrowExceptionForTryingToModifyUnmodifiableCollection() {
        garage.getCars().clear();
    }

    @Test
    public void testShouldFindAllCarsAboveCertainSpeed() {
        List<Car> carsWithMaxSpeed = garage.findAllCarsWithMaxSpeedAbove(SPEED);
        assertEquals(carsWithMaxSpeed.get(INDEX), lamborghini);
        assertEquals(CARS_IN_GARAGE, garage.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForTryingToAddNullCarInTheGarage() {
        garage.addCar(NULL_CAR);
    }

    @Test
    public void testShouldGetMostExpensiveCarFromTheGarage() {
        Car mostExpensiveCar = garage.getTheMostExpensiveCar();
        assertEquals(lamborghini, mostExpensiveCar);
    }

    @Test
    public void testShouldGetAllCarsFromTheGarageByTheGivenBrand() {
        List<Car> allCarsByBrand = garage.findAllCarsByBrand(CAR_BRAND);
        assertEquals(lamborghini, allCarsByBrand.get(INDEX));
    }
}
