package heroRepository;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

public class HeroRepositoryTests {
    private HeroRepository heroRepository;
    private Hero hero;

    @Before
    public void setUp() {
        this.heroRepository = new HeroRepository();
        this.hero = new Hero("Superman", 100);
        this.heroRepository.create(hero);
    }

    @Test
    public void testShouldAddHeroToRepositoryAndGetCorrectCount() {
        int expectedHeroesCount = 1;
        int actualHeroesCount = this.heroRepository.getCount();
        assertEquals(expectedHeroesCount, actualHeroesCount);
    }

    @Test(expected = NullPointerException.class)
    public void testShouldFailForNullHero() {
        this.heroRepository.create(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForExistingHero() {
        this.heroRepository.create(hero);
    }

    @Test(expected = NullPointerException.class)
    public void testShouldFailForNullNameInRemoveMethod() {
        this.heroRepository.remove(null);
    }

    @Test
    public void testShouldRemoveCorrectHeroWithGivenName() {
        boolean isRemoved = this.heroRepository.remove("Superman");
        assertTrue(isRemoved);
    }

    @Test
    public void testShouldReturnTheHeroWithTheHighestLevel() {
        this.heroRepository.create(new Hero("Iron Man", 99));
        Hero expected = this.hero;
        Hero actual = this.heroRepository.getHeroWithHighestLevel();
        assertEquals(expected, actual);
    }

    @Test
    public void testShouldGetCorrectHeroWithGivenName() {
        Hero expected = this.hero;
        Hero actual = this.heroRepository.getHero("Superman");
        assertEquals(expected, actual);
    }

    @Test
    public void testShouldReturnCollectionOfHeroes() {
        Collection<Hero> heroes = this.heroRepository.getHeroes();
        assertEquals(1, heroes.size());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testShouldThrowExceptionForTryingToChangeUnmodifiableCollection() {
        this.heroRepository.getHeroes().clear();
    }
}