package halfLife;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTests {
    public static Player player;
    public static Gun rifle;

   

    @Test
    public void testShouldCreatePlayerCorrectly() {
        String expectedName = "Boris";
        String actualName = player.getUsername();
        assertEquals(expectedName, actualName);

        int expectedHealth = 100;
        int actualHealth = player.getHealth();
        assertEquals(expectedHealth, actualHealth);
    }

    @Test(expected = NullPointerException.class)
    public void testShouldThrowExceptionForNullName() {
        new Player(null, 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForLessThanZeroHealth() {
        new Player("Hichi", -10);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testShouldThrowExceptionFoNonModifiableCollection() {
        player.addGun(rifle);
        player.getGuns().clear();
    }

    @Test(expected = IllegalStateException.class)
    public void testShouldThrowExceptionForAlreadyDeadPlayer() {
        Player playerZeroHealth = new Player("Die", 0);
        playerZeroHealth.takeDamage(10);
    }

    @Test
    public void testPlayerShouldTakeDamageAndDie() {
        Player playerToDie = new Player("Boris", 10);
        playerToDie.takeDamage(20);

        int expectedHealth = 0;
        int actualHealth = playerToDie.getHealth();
        assertEquals(expectedHealth, actualHealth);
    }

    @Test
    public void testPlayerShouldTakeDamageAndStayAlive() {
        Player playerToDie = new Player("Boris", 10);
        playerToDie.takeDamage(5);

        int expectedHealth = 5;
        int actualHealth = playerToDie.getHealth();
        assertEquals(expectedHealth, actualHealth);
    }

    @Test(expected = NullPointerException.class)
    public void testShouldThrowExceptionForNullGun() {
        player.addGun(null);
    }

    @Test
    public void testShouldRemoveGunFromPlayerCorrectly() {
        player.addGun(rifle);
        boolean isRemoved = player.removeGun(rifle);
        assertTrue(isRemoved);
        assertEquals(0, player.getGuns().size());
    }

    @Test
    public void testShouldGetCorrectGun() {
        player.addGun(rifle);
        Gun expected = rifle;
        Gun actual = player.getGun(rifle.getName());
        assertEquals(expected, actual);
    }
}
