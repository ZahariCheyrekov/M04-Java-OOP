package cats;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HouseTests {



    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForFullHouseCapacity() {
        house.addCat(cat);
        house.addCat(cat);
    }

    @Test
    public void testShouldRemoveCatCorrectlyFromTheCatHouse() {
        house.removeCat(cat.getName());
        assertEquals(ZERO_COUNT, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForNoSuchCatWithGivenName() {
        house.removeCat(NONE_EXISTING_CAT);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForNoSuchCatForSale() {
        house.catForSale(NONE_EXISTING_CAT);
    }

    @Test
    public void testShouldSetCatForSaleCorrectly() {
        Cat catForSale = house.catForSale(cat.getName());
        boolean isHungry = catForSale.isHungry();
        assertFalse(isHungry);
    }

    @Test
    public void testShouldReturnStatisticsForCatsInTheHouse() {
        assertEquals(STATISTICS_MESSAGE, house.statistics());
    }
}
