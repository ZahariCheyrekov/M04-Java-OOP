package heroRepository;

public class HeroRepositoryTests {

    public void testShouldGetTheHeroWithTheHighestLevel() {
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
