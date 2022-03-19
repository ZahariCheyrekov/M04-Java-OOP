package computers;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ComputerManagerTests {
   

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

  


  

}
