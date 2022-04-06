package heroRepository;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HeroRepositoryTests {


    private static final String HERO_NAME_NULL = null;
    private static final String HERO_NAME_HULK = "Hulk";
    private static final String HERO_NAME_BATMAN = "Batman";

    private static final int HERO_LEVEL_HUNDRED = 100;
    private static final int HERO_LEVEL_FIFTY = 50;

    private static final int HERO_COUNT_TWO = 2;

    private static final Hero BATMAN = new Hero(HERO_NAME_BATMAN, HERO_LEVEL_FIFTY);
    private static final Hero NULL_HERO = null;
    private static final Hero HERO_WITH_EXISTING_NAME = new Hero(HERO_NAME_HULK, HERO_LEVEL_FIFTY);

    private static final String SUCCESSFULLY_CREATED_HERO = "Successfully added hero %s with level %d";

    @Before
    public void setUp() {
        heroRepository = new HeroRepository();
        hulk = new Hero(HERO_NAME_HULK, HERO_LEVEL_HUNDRED);
        heroRepository.create(hulk);
    }

    @Test(expected = NullPointerException.class)
    public void testShouldThrowExceptionFoTryingToCreateHeroWithValueNull() {
        heroRepository.create(NULL_HERO);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForAlreadyExistingHeroWithThatName() {
        heroRepository.create(HERO_WITH_EXISTING_NAME);
    }

    @Test
    public void testShouldCreateHeroCorrectlyAndReturnTheInformationAboutCreation() {
        String expectedMessage = String.format(SUCCESSFULLY_CREATED_HERO, HERO_NAME_BATMAN, HERO_LEVEL_FIFTY);
        String actualMessage = heroRepository.create(BATMAN);

        assertEquals(expectedMessage, actualMessage);
    }

    @Test(expected = NullPointerException.class)
    public void testShouldThrowExceptionForNameWithValueNull() {
        heroRepository.remove(HERO_NAME_NULL);
    }

    @Test
    public void testShouldRemoveHeroFromTheRepositoryByTheGivenName() {
        boolean isRemoved = heroRepository.remove(HERO_NAME_HULK);
        assertTrue(isRemoved);
    }

    @Test
    public void testShouldGetTheHeroWithTheHighestLevel() {
        heroRepository.create(BATMAN);

        int actualHeroCount = heroRepository.getCount();
        assertEquals(HERO_COUNT_TWO, actualHeroCount);

        Hero heroWithHighestLevel = heroRepository.getHeroWithHighestLevel();
        assertEquals(hulk, heroWithHighestLevel);
    }

    @Test
    public void testShouldGetHeroByTheGivenNameCorrectly() {
        Hero heroByName = heroRepository.getHero(HERO_NAME_HULK);
        assertEquals(hulk, heroByName);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testShouldThrowExceptionForTryingToModifyUnmodifiableCollection() {
        heroRepository.getHeroes().clear();
    }
}
