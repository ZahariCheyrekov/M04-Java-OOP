
public class HouseTests {
    public void setUp() {
        house = new House(HOUSE_NAME, HOUSE_CAPACITY);
        cat = new Cat(CAT_NAME);
        house.addCat(cat);
    }

    @Test(expected = NullPointerException.class)
    public void testShouldThrowExceptionForInvalidNameWithValueNull() {
        new House(null, HOUSE_CAPACITY);
    }

    @Test
    public void testShouldGetHouseNameCorrectly() {
        assertEquals(HOUSE_NAME, house.getName());
    }

    @Test
    public void testShouldGetHouseCapacityCorrectly() {
        assertEquals(HOUSE_CAPACITY, house.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForInvalidCapacityBelowZero() {
        new House(HOUSE_NAME, INVALID_HOUSE_CAPACITY);
    }

    @Test
    public void testShouldGetCatsCountCorrectly() {
        assertEquals(HOUSE_COUNT, house.getCount());
    }

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
