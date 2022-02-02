package M04_JavaOOP.L10_UnitTesting.Exercises.T03IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;


public class ListIteratorTest {
    private static final String[] INITIAL_DATA = new String[]{"ONE", "TWO", "THREE"};

    private ListIterator listIterator;

    @Before
    public void startUp() throws OperationNotSupportedException {
        listIterator = new ListIterator(ListIteratorTest.INITIAL_DATA);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorShouldThrowExceptionWithNullParam() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator(null);
    }

    @Test
    public void testPrintShouldReturnCorrectElement() {
        Assert.assertEquals(ListIteratorTest.INITIAL_DATA[0], listIterator.print());
    }

    @Test(expected = IllegalStateException.class)
    public void testPrintOnEmptyListShouldThrowException() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator();
        listIterator.print();
    }

    @Test
    public void testHasNextShouldReturnFalseOnEmptyList() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator();

        Assert.assertFalse(listIterator.hasNext());
    }

    @Test
    public void testHasNextShouldReturnTrueIfThereAreNextElements() {
        Assert.assertTrue(listIterator.hasNext());
    }

    @Test
    public void testMoveShouldMoveCorrectlyToTheNextElement() {
        Assert.assertTrue(listIterator.move());
    }

    @Test
    public void testMoveShouldReturnFalseOnEndOfList() {
        for (int i = 0; i < 2; i++) {
            listIterator.move();
        }
        Assert.assertFalse(listIterator.move());
    }
}