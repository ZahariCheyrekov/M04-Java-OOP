package aquarium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class AquariumTests {

    @Test(expected = NullPointerException.class)
    public void testShouldFailForInvalidAquariumNameWithValueNull() {
        new Aquarium(null, 10);
    }

    @Test
    public void testShouldSetNumberOfTheAquariumCorrectly() {
        Aquarium aquarium = new Aquarium("Pesho", 10);
        String actual = aquarium.getName();
        assertEquals("Pesho", actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldFailForInvalidAquariumCapacityForLessThanZero() {
        new Aquarium("fish", -1);
    }

    @Test
    public void testShouldReturnTheCorrectCapacityOffTheAquariumAndCount() {
        Aquarium aquarium = new Aquarium("fish", 10);
        Fish fish = new Fish("Nemo");
        aquarium.add(fish);

        int actualCapacity = aquarium.getCapacity();
        int actualCount = aquarium.getCount();

        assertEquals(1, actualCount);
        assertEquals(10, actualCapacity);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldFailForNotEnoughSpaceInTheAquarium() {
        Aquarium aquarium = new Aquarium("fish", 1);
        Fish fish = new Fish("Nemo");
        Fish invalid = new Fish("NotNemo");

        aquarium.add(fish);
        aquarium.add(invalid);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldFailForNameWithValueNull() {
        Aquarium aquarium = new Aquarium("fish", 1);
        aquarium.remove("NoFish");
    }

    @Test
    public void testShouldRemoveFishFromTHeAquariumCorrectly() {
        Aquarium aquarium = new Aquarium("fish", 1);
        Fish fish = new Fish("Nemo");
        aquarium.add(fish);
        aquarium.remove("Nemo");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldFailForInvalidNameWithValueNullForMethodSellFish() {
        Aquarium aquarium = new Aquarium("fish", 1);
        aquarium.sellFish("NoFish");
    }

    @Test
    public void testShouldSellTheCorrectFishFromTheAquarium() {
        Aquarium aquarium = new Aquarium("fish", 1);
        Fish fish = new Fish("Nemo");
        aquarium.add(fish);
        aquarium.sellFish(fish.getName());
    }

    @Test
    public void testShouldReturnTheCorrectReportMethodForAvailableFishInAquarium() {
        Aquarium aquarium = new Aquarium("SharkTank", 10);
        Collection<Fish> fish = new ArrayList<>();
        Fish fishOne = new Fish("Nemo");
        Fish fishTwo = new Fish("Jerry");

        fish.add(fishOne);
        fish.add(fishTwo);

        aquarium.add(fishOne);
        aquarium.add(fishTwo);

        String names = fish.stream().map(Fish::getName).collect(Collectors.joining(", "));
        String expected = String.format("Fish available at %s: %s", aquarium.getName(), names);

        assertEquals(expected, aquarium.report());
    }

    @Test
    public void testSellFishShouldSetFishAsSold() {
        Aquarium aquarium = new Aquarium("SharkTank", 10);
        Fish fish = new Fish("test_fish");
        aquarium.add(fish);
        aquarium.sellFish("test_fish");
        assertFalse(fish.isAvailable());
    }
}