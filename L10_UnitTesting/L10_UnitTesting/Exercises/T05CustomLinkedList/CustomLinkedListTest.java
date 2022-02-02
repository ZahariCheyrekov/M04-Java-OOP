package M04_JavaOOP.L10_UnitTesting.Exercises.T05CustomLinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomLinkedListTest {
    private CustomLinkedList<Integer> linkedList;

    private static final Integer ELEMENT = 10;
    private static final Integer ELEMENT_TWO = 20;
    private static final Integer INDEX_ZERO = 0;
    private static final Integer INDEX_ONE = 1;
    private static final Integer ELEMENT_NOT_PRESENTED = 1;

    @Before
    public void createList() {
        this.linkedList = new CustomLinkedList<>();
    }

    @Test
    public void testAddingElementShouldAddCorrectly() {
        linkedList.add(ELEMENT);
        Assert.assertTrue(linkedList.contains(ELEMENT));
    }

    @Test
    public void testContainsShouldReturnTrueIfElementIsPresentInsideList() {
        linkedList.add(ELEMENT);
        Assert.assertTrue(linkedList.contains(ELEMENT));
    }

    @Test
    public void testContainsShouldReturnFalseOnEmptyList() {
        Assert.assertFalse(linkedList.contains(ELEMENT));
    }

    @Test
    public void testContainsShouldReturnFalseIfElementIsNotPresent() {
        linkedList.add(ELEMENT);
        Assert.assertFalse(linkedList.contains(ELEMENT_NOT_PRESENTED));
    }

    @Test
    public void testIndexOfReturnCorrectValue() {
        for (int i = 0; i < 100; i++) {
            linkedList.add(i);
        }
        Assert.assertEquals(linkedList.indexOf(99), 99);
    }

    @Test
    public void testIndexOfReturnMinusOneIfElementIsNotPresentInList() {
        Assert.assertEquals(linkedList.indexOf(ELEMENT_NOT_PRESENTED), -1);
    }

    @Test
    public void testShouldReturnTheCountOfElementsInList() {
        linkedList.add(ELEMENT);
        Integer count = linkedList.getCount();
        Assert.assertEquals(Integer.valueOf(1), count);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForInvalidIndex() {
        linkedList.get(ELEMENT);
    }

    @Test
    public void testShouldReturnCorrectElementFromList() {
        linkedList.add(ELEMENT);
        Integer element = linkedList.get(INDEX_ZERO);
        Assert.assertEquals(ELEMENT, element);
    }

    @Test
    public void testShouldReturnCorrectElementFromListAtIndexOne() {
        linkedList.add(ELEMENT);
        linkedList.add(ELEMENT);
        Integer element = linkedList.get(INDEX_ONE);
        Assert.assertEquals(ELEMENT, element);
    }

    @Test
    public void testShouldRemoveElementAtIndex() {
        linkedList.add(ELEMENT);
        Integer removedElement = linkedList.removeAt(INDEX_ZERO);
        Assert.assertEquals(ELEMENT, removedElement);
    }

    @Test
    public void testShouldRemoveElementAtIndexTwo() {
        linkedList.add(ELEMENT);
        linkedList.add(ELEMENT);
        linkedList.add(ELEMENT);
        Integer removedElement = linkedList.removeAt(INDEX_ONE);
        Assert.assertEquals(ELEMENT, removedElement);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForInvalidRemoveIndex() {
        linkedList.removeAt(ELEMENT);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForInvalidSetIndex() {
        linkedList.set(INDEX_ZERO, ELEMENT);
    }

    @Test
    public void testShouldSetElementAtSpecifiedIndexZero() {
        linkedList.add(ELEMENT);
        linkedList.set(INDEX_ZERO, ELEMENT_TWO);
    }

    @Test
    public void testShouldSetElementAtSpecifiedIndexOne() {
        linkedList.add(ELEMENT_TWO);
        linkedList.add(ELEMENT);
        linkedList.set(INDEX_ONE, ELEMENT);
    }

    @Test
    public void testShouldRemoveSpecifiedElementFromList() {
        linkedList.add(ELEMENT_TWO);
        linkedList.add(ELEMENT);
        linkedList.remove(ELEMENT);
    }

    @Test
    public void testReturnsInvalidIndexForElementNotPresentedInLst() {
        linkedList.remove(ELEMENT);
    }

    @Test
    public void testShouldRemoveNextListNodeFromList() {
        linkedList.add(ELEMENT);
        linkedList.add(null);
        linkedList.remove(ELEMENT);
    }
}