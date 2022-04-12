public class GarageTests {
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
