public class ComputerManagerTests {
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
