public class SpaceshipTests {
    private static final Astronaut SECOND_ASTRONAUT = new Astronaut("Second", 99);
    private static final Astronaut THIRD_ASTRONAUT = new Astronaut("Third", 98);

    private static final String SPACESHIP_NAME = "Diablo-XII";
    private static final int SPACESHIP_CAPACITY = 2;

    private static final String NULL_SPACESHIP_NAME = null;
    private static final int INVALID_SPACESHIP_CAPACITY = -10;

    private static final String ASTRONAUT_NAME = "Spaceman";
    private static final double ASTRONAUT_OXYGEN = 100;

    @Before
    public void setUp() {
        spaceship = new Spaceship(SPACESHIP_NAME, SPACESHIP_CAPACITY);
        astronaut = new Astronaut(ASTRONAUT_NAME, ASTRONAUT_OXYGEN);
        spaceship.add(astronaut);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionFOrNoMoreSpaceOnTheSpaceship() {
        spaceship.add(SECOND_ASTRONAUT);
        int actualAstronautsCount = spaceship.getCount();
        assertEquals(SPACESHIP_CAPACITY, actualAstronautsCount);

        spaceship.add(THIRD_ASTRONAUT);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForAlreadyExistingAstronautOnTheSpaceship() {
        spaceship.add(astronaut);
    }

    @Test
    public void testShouldRemoveAstronautByTheGivenNameCorrectly() {
        boolean isRemoved = spaceship.remove(ASTRONAUT_NAME);
        assertTrue(isRemoved);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForTryingToSetInvalidSpaceshipCapacity() {
        new Spaceship(SPACESHIP_NAME, INVALID_SPACESHIP_CAPACITY);
    }

    @Test(expected = NullPointerException.class)
    public void testShouldThrowExceptionForTryingToSetNullNameToTheSpaceship() {
        new Spaceship(NULL_SPACESHIP_NAME, SPACESHIP_CAPACITY);
    }

    @Test
    public void testShouldGetTheSpaceshipNameCorrectly() {
        String actualSpaceshipName = spaceship.getName();
        assertEquals(SPACESHIP_NAME, actualSpaceshipName);
    }
}
