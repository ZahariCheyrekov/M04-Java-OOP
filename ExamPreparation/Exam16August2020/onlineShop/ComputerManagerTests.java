public class ComputerManagerTests {
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
