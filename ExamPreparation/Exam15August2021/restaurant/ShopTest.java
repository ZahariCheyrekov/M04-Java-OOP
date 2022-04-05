package shopAndGoods;


public class ShopTest {

        Goods nonExistingGood = new Goods("nonExistingGood", "nonExistingCode");
        shop.removeGoods("Shelves1", nonExistingGood);
    }

    @Test
    public void testShouldRemoveGoodsFromTheShop() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", goods);

        String removed = shop.removeGoods("Shelves1", goods);
        String actual = "Goods: 1001 is removed successfully!";
        assertEquals(removed, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForNoneExistingShelfInShop() throws OperationNotSupportedException {
        shop.addGoods("none", goods);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForAlreadyTakenShelf() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", goods);
        Goods goodsSame = new Goods("testGood", "testCode");
        shop.addGoods("Shelves1", goodsSame);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testShouldThrowExceptionForAlreadyExistingGoods() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", goods);
        shop.addGoods("Shelves2", goods);
    }

    @Test
    public void testShouldPassForPlacedGoodsSuccessfully() throws OperationNotSupportedException {
        String expected = "Goods: 1001 is placed successfully!";
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
}
