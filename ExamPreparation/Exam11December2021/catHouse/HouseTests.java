package cats;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HouseTests {
    private House house;
    private Cat cat;

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
    public void testShouldReturnStatisticsForTheHouseAndTheCatsInIt() {
        String expectedStats = "The cat Garfield is in the house Java!";
        String actualStats = this.house.statistics();
        assertEquals(expectedStats, actualStats);
    }
}
