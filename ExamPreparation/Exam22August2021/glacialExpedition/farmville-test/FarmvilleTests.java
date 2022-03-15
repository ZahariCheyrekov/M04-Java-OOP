package farmville;

import org.junit.Assert;
import org.junit.Test;

public class FarmvilleTests {


    @Test(expected = NullPointerException.class)
    public void constructorShouldThrowExceptionBecauseNameIsNull() {
        new Farm(null, 5);
    }

    @Test(expected = NullPointerException.class)
    public void constructorShouldThrowExceptionBecauseNameIsEmpty() {
        new Farm("     ", 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorShouldThrowExceptionBecauseCapacityIsNegative() {
        new Farm("Cow Farm", -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addMethodShouldThrowBecauseFarmIsFull() {
        Farm farm = new Farm("Cow Farm", 0);
        farm.add(new Animal("Cow", 5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addMethodShouldThrowBecauseAnimalExists() {
        Farm farm = new Farm("Cow Farm", 5);
        farm.add(new Animal("Cow", 5));
        farm.add(new Animal("Cow", 12));
    }

    @Test
    public void addMethodShouldAddAnimal() {
        Farm farm = new Farm("Cow Farm", 5);
        Assert.assertEquals(0, farm.getCount());
        farm.add(new Animal("Pig", 120));
        Assert.assertEquals(1, farm.getCount());
    }

    @Test
    public void removeMethodShouldRemoveAnimal() {
        Farm farm = new Farm("Cow Farm", 5);
        Assert.assertEquals(0, farm.getCount());
        farm.add(new Animal("Pig", 120));
        Assert.assertEquals(1, farm.getCount());
        Assert.assertTrue(farm.remove("Pig"));
        Assert.assertEquals(0, farm.getCount());
    }

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
