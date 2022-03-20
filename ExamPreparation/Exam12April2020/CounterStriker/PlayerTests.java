package halfLife;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTests {

    private Player player;
    private final Player DEAD_PLAYER = new Player("dead", 0);
    private Gun gun;

    @Before
    public void setUp() {
        player = new Player("Glory", 100);
        gun = new Gun("Rifle", 100);
        player.addGun(gun);
    }

    @Test(expected = NullPointerException.class)
    public void testShouldThrowExceptionForNullName() {
        new Player(null, 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForHealthBelowZero() {
        new Player("invalid", -10);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testShouldThrowExceptionWhenTryingToModifyGunsCollection() {
        player.getGuns().clear();
    }

    @Test(expected = NullPointerException.class)
    public void testShouldThrowExceptionWhenTryingToAddNullGun() {
        player.addGun(null);
    }

    @Test
    public void testShouldRemoveGunFromPlayerCorrectly() {
        boolean isRemoved = player.removeGun(gun);
        assertTrue(isRemoved);
    }

    @Test
    public void testShouldReturnGunByGivenName() {
        Gun gunByName = player.getGun(this.gun.getName());
        assertEquals(gun, gunByName);
    }

    @Test(expected = IllegalStateException.class)
    public void testShouldThrowExceptionForAlreadyDeadPlayer() {
        DEAD_PLAYER.takeDamage(10);
    }

    @Test
    public void testShouldTakeDamageFromPlayerCorrectly() {
        player.takeDamage(10);
        int expectedHealth = 90;
        int actualHealth = player.getHealth();
        assertEquals(expectedHealth, actualHealth);

        player.takeDamage(100);
        boolean zeroHealth = player.getHealth() == 0;
        assertTrue(zeroHealth);
    }

    @Test
    public void testShouldGetUsernameCorrectly() {
        String expected = "Glory";
        String actual = player.getUsername();
        assertEquals(expected, actual);
    }
}
