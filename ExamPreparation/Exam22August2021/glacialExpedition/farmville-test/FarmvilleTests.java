package farmville;

import org.junit.Assert;
import org.junit.Test;

public class FarmvilleTests {

    @Test
    public void removeMethodShouldNotRemoveAnimal() {
        Farm farm = new Farm("Cow Farm", 5);
        Assert.assertEquals(0, farm.getCount());
        farm.add(new Animal("Pig", 120));
        Assert.assertEquals(1, farm.getCount());
        Assert.assertFalse(farm.remove("Dog"));
        Assert.assertEquals(1, farm.getCount());
    }
}
