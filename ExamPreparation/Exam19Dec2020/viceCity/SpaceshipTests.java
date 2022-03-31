package blueOrigin;

import static org.junit.Assert.*;

import org.junit.Test;

public class SpaceshipTests {

    

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
