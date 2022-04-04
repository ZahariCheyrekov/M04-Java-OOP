package farmville;



public class FarmvilleTests {

    @Test(expected = NullPointerException.class)
    public void testShouldThrowExceptionForFarmNameWithValueNull() {
        new Farm(NULL_NAME, FARM_CAPACITY);
    }

    @Test
    public void testShouldGetAnimalsCountFromFarmCorrectly() {
        int actualCount = farm.getCount();
        assertEquals(FARM_ANIMALS_COUNT, actualCount);
    }

    @Test
    public void testShouldGetFarmNameCorrectly() {
        String actualName = farm.getName();
        assertEquals(FARM_NAME, actualName);
    }
}
