public class SpaceshipTests {
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
