package cats;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HouseTests {

    private static House house;
    private static Cat cat;

    @Before
    public void setUp() {
        house = new House("Big House", 2);
        cat = new Cat("Garfield");
    }

    @Test(expected = NullPointerException.class)
    public void testShouldThrowExceptionForInvalidNameWithValueNull() {
        new House(null, 10);
    }

    @Test
    public void testShouldGetHouseNameCorrectly() {
        String actual = house.getName();
        String expected = "Big House";

        assertEquals(expected, actual);
    }

    @Test
    public void testShouldGetHouseCapacityCorrectly() {
        int actual = house.getCapacity();
        int expected = 2;

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForInvalidCapacityBelowZero() {
        new House("House", -10);
    }

    @Test
    public void testShouldGetCatsCountCorrectly() {
        house.addCat(cat);

        int actual = house.getCount();
        int expected = 1;

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForFullHouseCapacity() {
        house.addCat(cat);
        house.addCat(cat);
        house.addCat(cat);
    }

    @Test
    public void testShouldRemoveCatCorrectlyFromTheCatHouse() {
        house.addCat(cat);
        house.removeCat(cat.getName());

        int actualCount = house.getCount();
        int expectedCount = 0;

        assertEquals(expectedCount, actualCount);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForNoSuchCatWithGivenName() {
        house.addCat(cat);
        house.removeCat("Tom");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForNoSuchCatForSale() {
        house.addCat(cat);
        house.catForSale("Blue");
    }

    @Test
    public void testShouldSetCatForSaleCorrectly() {
        house.addCat(cat);
        Cat catForSale = house.catForSale(cat.getName());

        boolean isHungry = catForSale.isHungry();

        assertFalse(isHungry);
    }

    @Test
    public void testShouldReturnStatisticsForCatsInTheHouse() {
        house.addCat(cat);

        String actual = house.statistics();
        String expected = "The cat Garfield is in the house Big House!";

        assertEquals(expected, actual);
    }
}
