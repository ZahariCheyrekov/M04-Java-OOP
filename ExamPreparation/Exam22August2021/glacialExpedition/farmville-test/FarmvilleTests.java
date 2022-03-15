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
  
}
