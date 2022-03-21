package blueOrigin;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SpaceshipTests {

    @Test(expected = IllegalArgumentException.class)
    public void testAddAstronautWhenCapacityIsFullShouldFail() {
        Spaceship spaceship = new Spaceship("Spaceship", 1);
        spaceship.add(new Astronaut("testOne", 100));
        spaceship.add(new Astronaut("testTwo", 100));
    }

  
}
