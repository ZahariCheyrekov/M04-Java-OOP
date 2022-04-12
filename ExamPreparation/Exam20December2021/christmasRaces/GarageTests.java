public class GarageTests {
    public void testShouldFindAllCarsByTheGivenCarBrand() {
    }

    @Test
    public void testShouldFindAllCarsFromTheGarageWithMaxSpeedAboveGivenNumber() {
        List<Car> allCarsWithMaxSpeedAbove = garage.findAllCarsWithMaxSpeedAbove(CAR_SPEED);
        assertEquals(car, allCarsWithMaxSpeedAbove.get(CAR_LIST_INDEX));
    }
}
