package gifts;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GiftFactoryTests {

    private GiftFactory giftFactory;
    private Gift gift;

    private static final String GIFT_TYPE = "Car";
    private static final double GIFT_MAGIC = 100;

    private static final String GIFT_BALL = "Ball";
    private static final double GIFT_MAGIC_TWO = 200;

    private static final int ZERO_COUNT_GIFTS = 0;  
    private static final int GIFTS_COUNT = 1; 
    private static final int GIFTS_COUNT_TWO = 2;

    private static final String SUCCESSFULLY_ADDED_GIFT = "Successfully added gift Ball with magic 200.00.";

    @Before
    public void setUp() {
        giftFactory = new GiftFactory();
        gift = new Gift(GIFT_TYPE, GIFT_MAGIC);
        giftFactory.createGift(gift);
    }

    @Test
    public void testShouldGetGiftsCount() {
        int giftFactoryCount = giftFactory.getCount();
        assertEquals(giftFactoryCount, GIFTS_COUNT);
    }

    @Test(expected = IllegalArgumentException.class) 
    public void testShouldThrowExceptionForAlreadyExistingType() {
        giftFactory.createGift(new Gift(GIFT_TYPE, GIFT_MAGIC));
    }

    @Test
    public void testShouldReturnCorrectMessageForCreatingGift() {
        int startCount = giftFactory.getCount();
        assertEquals(1, startCount);

        String giftFactoryGift = giftFactory.createGift(new Gift(GIFT_BALL, GIFT_MAGIC_TWO));
        assertEquals(SUCCESSFULLY_ADDED_GIFT, giftFactoryGift);

        int count = giftFactory.getCount();
        assertEquals(GIFTS_COUNT_TWO, count);
    }

    @Test(expected = NullPointerException.class)
    public void testShouldThrowExceptionForTryingToRemoveGiftWithNullName() {
        giftFactory.removeGift(null);
    }

    @Test
    public void testShouldRemoveGiftByGivenNameFromFactoryCorrectly() {
        boolean isRemoved = giftFactory.removeGift(GIFT_TYPE);
        assertTrue(isRemoved);
        assertEquals(ZERO_COUNT_GIFTS, giftFactory.getCount());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testShouldThrowExceptionForTryingToModifyUnmodifiableCollection() {
        giftFactory.getPresents().clear();
    }

    @Test
    public void testShouldReturnCertainGiftByTheGivenName() {
        Gift present = giftFactory.getPresent(GIFT_TYPE);
        assertEquals(gift, present);
    }

    @Test
    public void testShouldGetPresentWithLeastMagic() {
        giftFactory.createGift(new Gift(GIFT_BALL, GIFT_MAGIC_TWO));
        Gift presentWithLeastMagic = giftFactory.getPresentWithLeastMagic();
        assertEquals(gift, presentWithLeastMagic);
    }

    @Test
    public void testShouldGetPresentType() {
        String type = gift.getType();
        assertEquals(GIFT_TYPE, type);
    }

    @Test
    public void testShouldGetPresents() {
        List<Gift> presents = new ArrayList<>(giftFactory.getPresents());
        assertEquals(gift, presents.get(0));
    }

    @Test(expected = NullPointerException.class)
    public void testShouldThrowExceptionForEmptyNameToRemove() {
        giftFactory.removeGift(" ");
    }

    @Test
    public void testShouldReturnNullForPresentWithNoSuchName() {
        Gift noneExisting = giftFactory.getPresent("noneExisting");
        assertNull(noneExisting);
    }

    @Test
    public void testShouldReturnNullForNoSuchPresentWithLeastMagic() {
        giftFactory.removeGift(GIFT_TYPE);
        Gift presentWithLeastMagic = giftFactory.getPresentWithLeastMagic();
        assertNull(presentWithLeastMagic);
    }
}
