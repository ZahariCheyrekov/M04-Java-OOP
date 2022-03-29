package computers;

public class ComputerManagerTests {


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
