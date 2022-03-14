package cats;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HouseTests {
    private House house;
    private Cat cat;

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
