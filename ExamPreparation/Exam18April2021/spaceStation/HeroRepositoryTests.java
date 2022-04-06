package heroRepository;

public class HeroRepositoryTests {




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
