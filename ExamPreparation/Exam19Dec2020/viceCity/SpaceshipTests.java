package blueOrigin;

import static org.junit.Assert.*;

import org.junit.Test;

public class SpaceshipTests {

    

    @Test
    public void testShouldGetSpaceshipAstronautsCountCorrectly() {
        spaceship.add(astronaut);
        int expectedCount = 1;
        int actualCount = spaceship.getCount();
        assertEquals(expectedCount, actualCount);
    }
}
