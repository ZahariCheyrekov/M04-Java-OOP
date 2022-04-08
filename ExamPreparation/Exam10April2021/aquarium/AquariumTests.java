


public class AquariumTests {
    @Test
    public void testShouldReturnTheReportForTheFishNamesInTheAquarium() {
        String expectedReport = String.format(REPORT_MESSAGE, aquarium.getName(), FISH_NAME);
        String aquariumReport = aquarium.report();
        assertEquals(expectedReport, aquariumReport);
    }

    @Test
    public void testShouldGetTheAquariumCapacityCorrectly() {
        int actualCapacity = aquarium.getCapacity();
        assertEquals(AQUARIUM_CAPACITY, actualCapacity);
    }
}
