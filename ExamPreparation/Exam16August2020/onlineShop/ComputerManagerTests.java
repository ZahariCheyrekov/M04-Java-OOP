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
        this.computerManager = new ComputerManager();
        this.computer = new Computer("Giga", "Acer", 100.0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testShouldThrowExceptionForUnmodifiableCollection() {
        this.computerManager.addComputer(computer);
        this.computerManager.getComputers().remove(0);
    }

    @Test
    public void testShouldReturnTheCorrectCountOfTheElementsInTheComputerManger() {
        this.computerManager.addComputer(computer);
        assertEquals(1, this.computerManager.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForNullComputerElement() {
        this.computerManager.addComputer(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldFailForAlreadyExistingComputerInTheComputerManger() {
        this.computerManager.addComputer(computer);
        this.computerManager.addComputer(computer);
    }

    @Test
    public void testShouldRemoveTheGivenComputerCorrectly() {
        Computer currentComputer = new Computer("Figo", "Mac", 2000);
        String manufacturer = currentComputer.getManufacturer();
        String model = currentComputer.getModel();

        this.computerManager.addComputer(currentComputer);
        this.computerManager.removeComputer(manufacturer, model);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForNullManufacturer() {
        this.computerManager.getComputer(null, "Acer");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForNullModel() {
        this.computerManager.getComputer("Giga", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForNoSuchComputerWithManufacturerAndModel() {
        this.computerManager.addComputer(computer);
        this.computerManager.getComputer("Javen", "LG");
    }

    @Test
    public void testShouldGetTheCorrectComputerByModelAndManufacturer() {
        this.computerManager.addComputer(computer);
        Computer actual = this.computerManager.getComputer("Giga", "Acer");
        Computer expected = computer;
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForNullManufacturerByGetManufacturerMethod() {
        this.computerManager.addComputer(computer);
        this.computerManager.getComputersByManufacturer(null);
    }

    @Test
    public void testShouldGetCorrectComputerByGetManufacturerMethod() {
        this.computerManager.addComputer(computer);
        List<Computer> computers = this.computerManager.getComputersByManufacturer("Giga");
        assertEquals(computer, computers.get(0));
    }
}