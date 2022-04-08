


public class AquariumTests {
    public void testShouldReturnTheReportForTheFishNamesInTheAquarium() {
    }

    @Test
    public void testShouldGetTheAquariumCapacityCorrectly() {
        int actualCapacity = aquarium.getCapacity();
        assertEquals(AQUARIUM_CAPACITY, actualCapacity);
    }
}
