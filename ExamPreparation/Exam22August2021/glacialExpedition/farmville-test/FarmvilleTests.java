package farmville;

import org.junit.Assert;
import org.junit.Test;

public class FarmvilleTests {

    //Everything works fine.
    @Test
    public void constructorShouldCreateFarm() {
        String name = "Cow farm";
        int capacity = 5;
        Farm farm = new Farm(name, capacity);

        Assert.assertEquals(name, farm.getName());
        Assert.assertEquals(capacity, farm.getCapacity());
    }

    //name is null -> exception
    @Test(expected = NullPointerException.class)
    public void constructorShouldThrowExceptionBecauseNameIsNull() {
        new Farm(null, 5);
    }

    //name is only white characters -> exception
    @Test(expected = NullPointerException.class)
    public void constructorShouldThrowExceptionBecauseNameIsEmpty() {
        new Farm("     ", 5);
    }

    //capacity < 0 -> exception
    @Test(expected = IllegalArgumentException.class)
    public void constructorShouldThrowExceptionBecauseCapacityIsNegative() {
        new Farm("Cow Farm", -1);
    }

    //1. if size == capacity -> Exception
    @Test(expected = IllegalArgumentException.class)
    public void addMethodShouldThrowBecauseFarmIsFull() {
        Farm farm = new Farm("Cow Farm", 0);
        farm.add(new Animal("Cow", 5));

    }

    //2. if animal exists -> Exception
    @Test(expected = IllegalArgumentException.class)
    public void addMethodShouldThrowBecauseAnimalExists() {
        Farm farm = new Farm("Cow Farm", 5);
        farm.add(new Animal("Cow", 5));
        farm.add(new Animal("Cow", 12));

    }

    //3. animal is added
    @Test
    public void addMethodShouldAddAnimal() {
        Farm farm = new Farm("Cow Farm", 5);
        Assert.assertEquals(0, farm.getCount());
        farm.add(new Animal("Pig", 120));
        Assert.assertEquals(1, farm.getCount());
    }


    //1. animal is removed
    @Test
    public void removeMethodShouldRemoveAnimal() {
        Farm farm = new Farm("Cow Farm", 5);
        Assert.assertEquals(0, farm.getCount());
        farm.add(new Animal("Pig", 120));
        Assert.assertEquals(1, farm.getCount());
        Assert.assertTrue(farm.remove("Pig"));
        Assert.assertEquals(0, farm.getCount());


    }

    //2. no animal is removed
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
