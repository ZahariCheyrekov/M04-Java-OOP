package M04_JavaOOP.L10_UnitTesting.Exercises.T01Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private static final Integer[] NUMBERS = {1, 2, 3, 4};
    private static final Integer[] TOO_BIG_ARRAY = new Integer[17];
    private static final Integer[] TOO_SMALL_ARRAY = new Integer[0];

    private Database database;

    @Before
    public void setUp() throws OperationNotSupportedException {
        this.database = new Database(NUMBERS);
    }

    @Test
    public void testShouldCreateValidDatabase() {
        Integer[] dbElements = database.getElements();
        Assert.assertEquals(NUMBERS.length, dbElements.length);

        for (int i = 0; i < NUMBERS.length; i++) {
            Assert.assertEquals("Different elements in database", dbElements[i], NUMBERS[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testThrowsExceptionForMoreThan16Elements() throws OperationNotSupportedException {
        new Database(TOO_BIG_ARRAY);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testThrowsExceptionForTooSmallArraySize() throws OperationNotSupportedException {
        new Database(TOO_SMALL_ARRAY);
    }

    @Test
    public void testShouldSetElementsCorrectly() throws OperationNotSupportedException {
        new Database(NUMBERS);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testShouldThrowExceptionForNullElement() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testShouldAddElementAndIncreaseSizeByOne() throws OperationNotSupportedException {
        database.add(5);
        Integer[] dbElements = database.getElements();

        Assert.assertEquals(NUMBERS.length + 1, dbElements.length);
        Assert.assertEquals(Integer.valueOf(5), dbElements[dbElements.length - 1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testThrowSExceptionForInvalidIndexInArray() throws OperationNotSupportedException {
        for (int i = 0; i < NUMBERS.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test
    public void testRemovedLastElementFromArraySuccessfully() throws OperationNotSupportedException {
        database.remove();
        Integer[] dbElements = database.getElements();
        Assert.assertEquals(NUMBERS.length - 1, dbElements.length);
        Assert.assertEquals(Integer.valueOf(3), dbElements[dbElements.length - 1]);
    }
}