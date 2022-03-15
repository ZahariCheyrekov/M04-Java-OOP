package farmville;

import org.junit.Assert;
import org.junit.Test;

public class FarmvilleTests {

   private static Farm farm;
   private static Animal animal;

    @Before
    public void setUp() {
        farm = new Farm("Old Duck", 2);
        animal = new Animal("Lion", 100);
        farm.add(animal);
    }
  
    @Test
    public void testShouldGetInformationFromFarmCorrectly() {
        int expectedAnimalsCount = 1;
        int actualAnimalsCount = farm.getCount();

        assertEquals(expectedAnimalsCount, actualAnimalsCount);

        String expectedName = "Old Duck";
        String actualName = farm.getName();

        assertEquals(expectedName, actualName);
    }
   
   @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForFullCapacityInFarm() {
        farm.add(new Animal("Eagle", 50));
        farm.add(new Animal("Gorilla", 75));
    }
   
   
}
