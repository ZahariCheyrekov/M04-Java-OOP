public class AquariumTests {
    private static final int AQUARIUM_CAPACITY = 2;
    private static final int INVALID_AQUARIUM_CAPACITY = -10;
    private static final int ZERO_FISH_COUNT = 0;

    private static final String FISH_NAME = "Jeffry";
    private static final String BREAM_NAME = "Bri";
    private static final String CLOWNFISH_NAME = "Downfall";
    private static final String NULL_AQUARIUM_NAME = null;

    private static final Fish BREAM = new Fish(BREAM_NAME);
    private static final Fish CLOWNFISH = new Fish(CLOWNFISH_NAME);
    private static final String REPORT_MESSAGE = "Fish available at %s: %s";

    @Before
    public void setUp() {
        aquarium = new Aquarium(AQUARIUM_NAME, AQUARIUM_CAPACITY);
        fish = new Fish(FISH_NAME);
        aquarium.add(fish);
    }

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
