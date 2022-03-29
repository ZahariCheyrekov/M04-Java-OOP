package computers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ComputerManagerTests {

   private ComputerManager computerManager;
    private Computer computer;
    private static final Computer NULL_COMPUTER = null;

    private static final String COMPUTER_MANUFACTURER = "IGS";
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
}
