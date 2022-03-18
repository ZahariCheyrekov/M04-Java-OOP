package aquarium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AquariumTests {

    private Aquarium aquarium;
    private Fish fish;

    @Before
    public void setUp() {
        aquarium = new Aquarium("Odium", 2);
        fish = new Fish("Nemo");
        aquarium.add(fish);
    }

    @Test(expected = NullPointerException.class)
    public void testShouldThrowExceptionFoNullAquariumName() {
        new Aquarium(null, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForNegativeAquariumCapacity() {
        new Aquarium("Aqua", -10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForNoAquariumCapacity() {
        aquarium.add(fish);
        aquarium.add(fish);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForNoneExistingFishToRemove() {
        aquarium.remove("noneExisting");
    }

    @Test
    public void testShouldRemoveFishFromAquariumCorrectly() {
        aquarium.remove(fish.getName());
        assertEquals(0, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForNoneExistingFishWithGivenName() {
        aquarium.sellFish("Goldy");
    }

    @Test
    public void testShouldSellFishCorrectlyAndSetAvailableToFalse() {
        Fish soldFish = aquarium.sellFish(fish.getName());
        assertEquals(fish, soldFish);
        assertFalse(fish.isAvailable());
    }

    @Test
    public void testShouldReturnReportForTheAquarium() {
        String expected = "Fish available at Odium: Nemo";
        String actual = aquarium.report();

        assertEquals(expected, actual);
    }

    @Test
    public void testShouldGetAquariumCapacity() {
        int expected = 2;
        int actual = aquarium.getCapacity();
        assertEquals(expected, actual);
    }

    @Test
    public void testShouldGetAquariumName() {
        String expected = "Odium";
        String actual = aquarium.getName();
        assertEquals(expected, actual);
    }
}
