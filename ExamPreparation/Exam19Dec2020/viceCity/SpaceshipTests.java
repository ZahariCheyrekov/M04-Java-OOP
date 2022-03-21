package blueOrigin;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SpaceshipTests {

    @Test
    public void testRemoveAstronautShouldReturnTrueWhenSuchAdded() {
        spaceship.add(new Astronaut("testOne", 100));
        assertTrue(spaceship.remove("testOne"));
    }
    
    @Test
    public void testGetAstronautsCountShouldReturnZeroWhenEmpty() {
        assertEquals(0, spaceship.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddSameAstronautTwiceShouldFail() {
        spaceship.add(new Astronaut("testOne", 100));
        spaceship.add(new Astronaut("testOne", 100));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAstronautWhenCapacityIsFullShouldFail() {
        Spaceship spaceship = new Spaceship("Spaceship", 1);
        spaceship.add(new Astronaut("testOne", 100));
        spaceship.add(new Astronaut("testTwo", 100));
    }

  
}
