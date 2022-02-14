package cats;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HouseTests {
    private House house;
    private Cat cat;

    @Before
    public void setUp() {
        this.house = new House("Java", 2);
        this.cat = new Cat("Garfield");
        this.house.addCat(cat);
    }

    @Test(expected = NullPointerException.class)
    public void testShouldThrowExceptionForNullName() {
        new House(null, 10);
    }

    @Test
    public void testShouldGetNameAndCapacityOfTheHouseCorrectly() {
        int houseCapacity = this.house.getCapacity();
        assertEquals(2, houseCapacity);

        String houseName = this.house.getName();
        assertEquals("Java", houseName);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForInvalidHouseCapacity() {
        new House("home", -10);
    }

    @Test
    public void testShouldReturnCorrectNumberOfCats() {
        int catsCount = this.house.getCount();
        assertEquals(1, catsCount);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForNoSpaceInTheHouse() {
        this.house.addCat(cat);
        this.house.addCat(cat);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldFailForNoExistingCatWithGivenName() {
        this.house.removeCat("Jeff");
    }

    @Test
    public void testShouldRemoveCorrectlyTheGivenCatByName() {
        this.house.removeCat("Garfield");
        int expected = 0;
        int actual = this.house.getCount();
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldFailForNoSuchCatForSaleInTheHouse() {
        this.house.catForSale("Jess");
    }

    @Test
    public void testShouldSaleCorrectlyTheGivenCatByName() {
        this.house.catForSale("Garfield");
        assertFalse(this.cat.isHungry());
    }

    @Test
    public void testShouldReturnStatisticsForTheHouseAndTheCatsInIt() {
        String expectedStats = "The cat Garfield is in the house Java!";
        String actualStats = this.house.statistics();
        assertEquals(expectedStats, actualStats);
    }
}