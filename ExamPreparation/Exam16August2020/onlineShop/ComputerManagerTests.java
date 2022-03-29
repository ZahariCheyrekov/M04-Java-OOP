package computers;

public class ComputerManagerTests {

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForNullComputer() {
        computerManager.addComputer(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForAlreadyExistingComputer() {
        computerManager.addComputer(computer);
    }

    @Test
    public void testShouldRemoveComputerFromTheManager() {
        String manufacturer = "Acer";
        String model = "Aspire";

        Computer removed = computerManager.removeComputer(manufacturer, model);
        assertEquals(computer, removed);

        int computersInManufacturer = computerManager.getCount();
        assertEquals(0, computersInManufacturer);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForNoneExistingComputerWithManufacturerAndModel() {
        computerManager.removeComputer("Apple", "Apple");
    }

    @Test
    public void testShouldGetComputersByGivenManufacturer() {
        List<Computer> computersByManufacturer = computerManager.getComputersByManufacturer("Acer");
        assertEquals(computer, computersByManufacturer.get(0));
    }
}
