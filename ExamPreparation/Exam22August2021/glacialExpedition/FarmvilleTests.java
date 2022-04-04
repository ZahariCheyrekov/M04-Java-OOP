package farmville;



public class FarmvilleTests {


    @Test
    public void testShouldGetFarmNameCorrectly() {
        String actualName = farm.getName();
        assertEquals(FARM_NAME, actualName);
    }
}
