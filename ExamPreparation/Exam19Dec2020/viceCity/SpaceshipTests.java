public class SpaceshipTests {
    public void testShouldThrowExceptionForTryingToSetNullNameToTheSpaceship() {
    }

    @Test
    public void testShouldGetTheSpaceshipNameCorrectly() {
        String actualSpaceshipName = spaceship.getName();
        assertEquals(SPACESHIP_NAME, actualSpaceshipName);
    }
}
