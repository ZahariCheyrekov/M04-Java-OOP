public class GarageTests {

    @Test(expected = UnsupportedOperationException.class)
    public void testShouldThrowExceptionForTryingToModifyUnmodifiableCollection() {
        garage.getCars().clear();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForTryingToAddNullCarInTheGarage() {
        garage.addCar(null);
    }

    @Test
    public void testShouldFindTheMostExpensiveCarByTheGivenPrice() {
        Car mostExpensiveCar = garage.getTheMostExpensiveCar();
        assertEquals(car, mostExpensiveCar);
        assertEquals(CARS_IN_GARAGE, garage.getCount());
    }

    @Test
    public void testShouldFindAllCarsByTheGivenCarBrand() {
        List<Car> allCarsByBrand = garage.findAllCarsByBrand(CAR_BRAND);
        assertEquals(car, allCarsByBrand.get(CAR_LIST_INDEX));
    }

    @Test
    public void testShouldFindAllCarsFromTheGarageWithMaxSpeedAboveGivenNumber() {
        List<Car> allCarsWithMaxSpeedAbove = garage.findAllCarsWithMaxSpeedAbove(CAR_SPEED);
        assertEquals(car, allCarsWithMaxSpeedAbove.get(CAR_LIST_INDEX));
    }
}
