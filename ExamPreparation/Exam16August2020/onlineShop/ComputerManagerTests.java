package computers;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ComputerManagerTests {
   

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForNullManufacturer() {
        this.computerManager.getComputer(null, "Acer");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForNullModel() {
        this.computerManager.getComputer("Giga", null);
    }

  


  

}
