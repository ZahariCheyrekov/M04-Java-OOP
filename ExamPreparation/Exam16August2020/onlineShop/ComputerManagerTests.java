package computers;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ComputerManagerTests {

    private ComputerManager computerManager;
    private Computer computer;

    @Before
    public void setUp() {
        computerManager = new ComputerManager();
        computer = new Computer("Acer", "Aspire", 10);
        computerManager.addComputer(computer);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testShouldThrowExceptionForNonModifiableCollection() {
        computerManager.getComputers().clear();

        int countComputers = computerManager.getCount();
        assertEquals(1, countComputers);
    }

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
