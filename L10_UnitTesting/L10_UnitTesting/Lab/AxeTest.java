package M04_JavaOOP.L10_UnitTesting.Lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AxeTest {

    private static final int ATTACK_POINTS = 10;
    private static final int DURABILITY = 10;
    private static final int DURABILITY_POINTS = 1;
    private static final int BROKEN_AXE_POINTS = 0;

    private Axe axe;
    private Axe brokenAxe;
    private Dummy dummy;

    @Before
    public void setUp() {
        this.axe = new Axe(ATTACK_POINTS, DURABILITY);
        this.brokenAxe = new Axe(ATTACK_POINTS, BROKEN_AXE_POINTS);
        this.dummy = new Dummy(ATTACK_POINTS, DURABILITY);
    }

    @Test
    public void testAxeLosesDurabilityAfterAttack() {
        axe.attack(dummy);
        Assert.assertEquals(DURABILITY - DURABILITY_POINTS, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void testAxeAttackThrowsIfAxeIsBroken() {
        brokenAxe.attack(dummy);
    }
}