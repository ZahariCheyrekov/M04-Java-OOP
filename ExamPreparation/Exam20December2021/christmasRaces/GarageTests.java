public class GarageTests {

    private Garage garage;
    private Car car;

    private static final String CAR_BRAND = "Lamborghini";
    private static final int MAX_SPEED_LAMBORGHINI = 350;
    private static final double PRICE_LAMBORGHINI = 100_000;

    private static final int CARS_IN_GARAGE = 1;
    private static final int CAR_SPEED = 200;

    private static final int CAR_LIST_INDEX = 0;

    @Before
    public void setUp() {
        garage = new Garage();
        car = new Car(CAR_BRAND, MAX_SPEED_LAMBORGHINI, PRICE_LAMBORGHINI);
        garage.addCar(car);
    }

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
