
public class FarmvilleTests {


  private static final String FARM_NAME = "HappyFarm";
  private static final String NULL_NAME = null;
  private static final int FARM_CAPACITY = 2;
  private static final int INVALID_CAPACITY = -10;
  private static final int FARM_ANIMALS_COUNT = 1;
  
  private static final String DOG_TYPE = "Dog";
  private static final String COW_TYPE = "Cow";
  private static final String SHEEP_TYPE = "Sheep";
  private static final double ANIMAL_ENERGY = 100;
  
  private static final Animal cow = new Animal(COW_TYPE, ANIMAL_ENERGY);
  private static final Animal sheep = new Animal(SHEEP_TYPE, ANIMAL_ENERGY);

  @Before
  public void setUp() {
    farm = new Farm(FARM_NAME, FARM_CAPACITY);
    dog = new Animal(DOG_TYPE, ANIMAL_ENERGY);
    farm.add(dog);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testShouldThrowExceptionForNoMoreSpaceInTheAnimalFarm() {
    farm.add(cow);
    farm.add(sheep);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testShouldThrowExceptionForAlreadyExistingAnimalInTheFarm() {
    farm.add(dog);
  }
  
  @Test
  public void testShouldRemoveAnimalByGivenNameFromTheFarm() {
    boolean isRemoved = farm.remove(DOG_TYPE);
    assertTrue(isRemoved);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testShouldThrowExceptionForInvalidFarmCapacity() {
    new Farm(FARM_NAME, INVALID_CAPACITY);
  }
 
  @Test(expected = NullPointerException.class)
  public void testShouldThrowExceptionForFarmNameWithValueNull() {
    new Farm(NULL_NAME, FARM_CAPACITY);
  }
  
  @Test
  public void testShouldGetAnimalsCountFromFarmCorrectly() {
    int actualCount = farm.getCount();
    assertEquals(FARM_ANIMALS_COUNT, actualCount);
  }

  @Test
  public void testShouldGetFarmNameCorrectly() {
    String actualName = farm.getName();
    assertEquals(FARM_NAME, actualName);
  }
}
