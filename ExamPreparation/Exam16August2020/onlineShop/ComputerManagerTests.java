public class ComputerManagerTests {
    private static final String COMPUTER_MODEL = "KL-012";
    private static final double COMPUTER_PRICE = 100_000;

    private static final String NONE_EXISTING_MANUFACTURER = "MGB";
    private static final String NONE_EXISTING_MODEL = "AVOCADO-10";

    private static final int COMPUTER_INDEX = 0;
    private static final int COMPUTERS_COUNT = 1;

    @Before
    public void setUp() {
        computerManager = new ComputerManager();
        computer = new Computer(COMPUTER_MANUFACTURER, COMPUTER_MODEL, COMPUTER_PRICE);
        computerManager.addComputer(computer);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testShouldThrowExceptionForTryingToModifyUnmodifiableCollection() {
        computerManager.getComputers().clear();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForTryingToAddComputerWithValueNull() {
        computerManager.addComputer(NULL_COMPUTER);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionWhenTryingToAddAlreadyExistingComputer() {
        computerManager.addComputer(computer);
    }

    @Test
    public void testShouldRemoveComputerByGivenManufacturerAndModel() {
        Computer removedComputer = computerManager.removeComputer(COMPUTER_MANUFACTURER, COMPUTER_MODEL);
        assertEquals(computer, removedComputer);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldTrowExceptionForNoneExistingManufacturerAndModelInComputerManger() {
        computerManager.getComputer(NONE_EXISTING_MANUFACTURER, NONE_EXISTING_MODEL);
    }

    @Test
    public void testShouldGetComputerByManufacturerAndModel() {
        Computer computerByManufacturerAndModel = computerManager.getComputer(COMPUTER_MANUFACTURER, COMPUTER_MODEL);
        assertEquals(computer, computerByManufacturerAndModel);
    }

    @Test
    public void testShouldGetComputerByManufacturerCorrectly() {
        List<Computer> computersByManufacturer = computerManager.getComputersByManufacturer(COMPUTER_MANUFACTURER);
        assertEquals(computer, computersByManufacturer.get(COMPUTER_INDEX));
    }

    @Test
    public void testShouldGetComputersCountFromTheComputerManager() {
        int computerManagerCount = computerManager.getCount();
        assertEquals(COMPUTERS_COUNT, computerManagerCount);
    }
}
