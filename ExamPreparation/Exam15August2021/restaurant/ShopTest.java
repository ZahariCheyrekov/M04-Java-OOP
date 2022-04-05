package shopAndGoods;


public class ShopTest {



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
