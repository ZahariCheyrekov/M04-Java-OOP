package M04_JavaOOP.L10_UnitTesting.Lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class HeroTest {
    private Hero hero;

    @Before
    public void setUp() {
        Weapon mock = Mockito.mock(Weapon.class);
        this.hero = new Hero("Ragnarok", mock);
    }

    @Test
    public void testUponTargetKillHeroGetsXp() {
        Target mockedTarget = Mockito.mock(Target.class);
        Mockito.when(mockedTarget.isDead()).thenReturn(true);
        Mockito.when(mockedTarget.giveExperience()).thenReturn(100);

        this.hero.attack(mockedTarget);
        Assert.assertEquals(100, this.hero.getExperience());
    }

    @Test
    public void testUponTargetAttackWhileTargetIsStillAliveHeroGetsNoXp() {
        Target mockedTarget = Mockito.mock(Target.class);
        this.hero.attack(mockedTarget);
        Assert.assertEquals(0, this.hero.getExperience());
    }
}