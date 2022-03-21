package blueOrigin;

import static org.junit.Assert.*;

import org.junit.Test;

public class SpaceshipTests {

    private final Spaceship spaceship = new Spaceship("FlagonXII", 2);
    private final Astronaut astronaut = new Astronaut("Spaceman", 100);

    @Test(expected = NullPointerException.class)
    public void testShouldThrowExceptionForNullSpaceshipName() {
        new Spaceship(null, 10);
    }

    @Test
    public void testShouldCreateSpaceshipCorrectly() {
        new Spaceship("FlagonXII", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForLessThanZeroCapacityForTheSpaceship() {
        new Spaceship("GalaxyI", -10);
    }

    @Test
    public void testShouldRemoveAstronautFromTheSpaceship() {
        spaceship.add(astronaut);
        boolean isRemoved = spaceship.remove(astronaut.getName());
        assertTrue(isRemoved);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForNoMoreCapacityOnTheSpaceship() {
        spaceship.add(astronaut);
        spaceship.add(new Astronaut("Spaceman2", 100));
        spaceship.add(new Astronaut("Spaceman3", 100));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForAlreadyExistingAstronautOnTheSpaceship() {
        spaceship.add(astronaut);
        spaceship.add(astronaut);
    }
    @Test
    public void testShouldGetSpaceshipNameCorrectly() {
        String expectedName = "FlagonXII";
        String actualName = spaceship.getName();
        assertEquals(expectedName, actualName);
    }
    @Test
    public void testShouldGetSpaceshipAstronautsCountCorrectly() {
        spaceship.add(astronaut);
        int expectedCount = 1;
        int actualCount = spaceship.getCount();
        assertEquals(expectedCount, actualCount);
    }
}
