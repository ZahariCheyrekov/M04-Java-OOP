package computers;

public class ComputerManagerTests {


        List<Computer> computersByManufacturer = computerManager.getComputersByManufacturer("Acer");
        assertEquals(computer, computersByManufacturer.get(0));
    }
}
