public class FarmvilleTests {

  
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
