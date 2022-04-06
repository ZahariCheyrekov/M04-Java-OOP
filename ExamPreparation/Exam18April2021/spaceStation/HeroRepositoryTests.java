package heroRepository;

public class HeroRepositoryTests {

    public void testShouldGetTheHeroWithTheHighestLevel() {
    }

  

    @Test(expected = UnsupportedOperationException.class)
    public void testShouldThrowExceptionForTryingToModifyUnmodifiableCollection() {
        heroRepository.getHeroes().clear();
    }
}
