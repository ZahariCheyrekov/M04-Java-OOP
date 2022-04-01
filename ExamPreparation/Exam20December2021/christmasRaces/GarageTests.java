package garage;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
ngage.getTheMostExpensiveCar();
        assertEquals(lamborghini, mostExpensiveCar);
    }

    @Test
    public void testShouldGetAllCarsFromTheGarageByTheGivenBrand() {
        List<Car> allCarsByBrand = garage.findAllCarsByBrand(CAR_BRAND);
        assertEquals(lamborghini, allCarsByBrand.get(INDEX));
    }
}
