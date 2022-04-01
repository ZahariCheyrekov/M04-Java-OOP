package garage;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
ng CAR_BRAND = "Lamborghini";
    private static final int SPEED = 500;
    private static final int CARS_IN_GARAGE = 2;
    private static final int INDEX = 0;


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
