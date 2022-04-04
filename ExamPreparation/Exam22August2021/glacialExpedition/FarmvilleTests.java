package farmville;



public class FarmvilleTests {

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
