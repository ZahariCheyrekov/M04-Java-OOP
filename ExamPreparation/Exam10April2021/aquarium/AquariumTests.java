


public class AquariumTests {

    @Test(expected = NullPointerException.class)
    public void testShouldThrowExceptionForTryingToSetNullAquariumName() {
        new Aquarium(NULL_AQUARIUM_NAME, AQUARIUM_CAPACITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForTryingToSetInvalidAquariumCapacity() {
        new Aquarium(AQUARIUM_NAME, INVALID_AQUARIUM_CAPACITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForNoMoreSpaceInTheAquarium() {
        aquarium.add(BREAM);
        aquarium.add(CLOWNFISH);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldTrowExceptionWhenTryingToRemoveNoneExistingFish() {
        aquarium.add(BREAM);
        aquarium.remove(CLOWNFISH_NAME);
    }

    @Test
    public void testShouldRemoveFishFromTheAquariumCorrectly() {
        aquarium.remove(FISH_NAME);
        assertEquals(ZERO_FISH_COUNT, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForTryingToRemoveFishWithNoSuchNameFromTheAquarium() {
        aquarium.sellFish(CLOWNFISH_NAME);
    }

    @Test
    public void testShouldSellFishFromTheAquariumByTheGivenName() {
        Fish soldFish = aquarium.sellFish(FISH_NAME);
        assertEquals(fish, soldFish);
        assertFalse(soldFish.isAvailable());
    }

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
