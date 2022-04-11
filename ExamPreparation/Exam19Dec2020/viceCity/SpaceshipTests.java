public class SpaceshipTests {
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
