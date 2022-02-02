package M04_JavaOOP.L10_UnitTesting.Lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DummyTest {

    private static final int HEALTH = 100;
    private static final int DEATH_DUMMY_HEALTH = 0;
    private static final int XP = 50;
    private static final int ATTACK_POINTS = 10;

    private Dummy dummy;
    private Dummy deathDummy;

    @Before
    public void setUp() {
        this.dummy = new Dummy(HEALTH, XP);
        this.deathDummy = new Dummy(DEATH_DUMMY_HEALTH, XP);
    }

    @Test
    public void testDummyLosesHealthWhenAttacked() {
        dummy.takeAttack(ATTACK_POINTS);
        Assert.assertEquals(HEALTH - ATTACK_POINTS, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testDeathDummyThrowsWhenAttacked() {
        deathDummy.takeAttack(HEALTH - ATTACK_POINTS);
    }

    @Test
    public void testDeathDummyGivesXp() {
        int actual = deathDummy.giveExperience();
        Assert.assertEquals(XP, actual);
    }

    @Test(expected = IllegalStateException.class)
    public void testAliveDummyThrowsWhenGivingXp() {
        dummy.giveExperience();
    }
}