package shopAndGoods;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ShopTest {
    private Shop shop;

    @Before
    public void setUp() {
        this.shop = new Shop();
    }

    @Test
    public void testShouldFailForExistingItem() throws OperationNotSupportedException {
        Goods goods = new Goods("testGood", "testCode");
        String expected = "Goods: testCode is placed successfully!";
        String actual = shop.addGoods("Shelves1", goods);
        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveGoodsShouldSetTheShelveValueToNull() throws OperationNotSupportedException {
        Goods goods = new Goods("testGood", "testCode");
        shop.addGoods("Shelves1", goods);
        shop.removeGoods("Shelves1", goods);

        Goods emptySlot = shop.getShelves().get("Shelves1");
        assertNull(emptySlot);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testShouldReturnUnmodifiableCollection() {
        shop.getShelves().clear();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveGoodsShouldFailForInvalidShelve() {
        shop.removeGoods("invalidTestShelve", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldFailForNonExistingShelf() throws OperationNotSupportedException {
        shop.addGoods("nonExisting", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForAlreadyTakenShelf() throws OperationNotSupportedException {
        Goods goods = new Goods("testGood", "testCode");
        shop.addGoods("Shelves1", goods);
        Goods goodsSame = new Goods("testGood", "testCode");
        shop.addGoods("Shelves1", goodsSame);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testShouldFailForDuplicatingItemInTheShop() throws OperationNotSupportedException {
        Goods goods = new Goods("testGood", "testCode");
        shop.addGoods("Shelves1", goods);
        shop.addGoods("Shelves2", goods);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForNonExistingGoodOnShelf() throws OperationNotSupportedException {
        Goods goods = new Goods("testGood", "testCode");
        shop.addGoods("Shelves1", goods);

        Goods nonExistingGood = new Goods("nonExistingGood", "nonExistingCode");
        shop.removeGoods("Shelves1", nonExistingGood);
    }

    @Test
    public void testRemoveGoodsShouldReturnCorrectMessage() throws OperationNotSupportedException {
        Goods goods = new Goods("testGood", "testCode");
        shop.addGoods("Shelves1", goods);
        String expected = "Goods: testCode is removed successfully!";
        String actual = shop.removeGoods("Shelves1", goods);
        assertEquals(expected, actual);
    }
}