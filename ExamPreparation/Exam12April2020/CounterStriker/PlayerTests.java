

import org.junit.Before;
import org.junit.Test;

public class PlayerTests {

    private Player player;
    private Gun gun;

    private static final String PLAYER_USERNAME = "Neo";
    private static final int PLAYER_HEALTH = 100;

    private static final String GUN_NAME = "Rifle";
    private static final int GUN_BULLETS = 50;

    private static final Gun NULL_GUN = null;
    private static final String NULL_NAME = null;
    private static final int INVALID_HEALTH = -100;

    private static final int FIFTY_DAMAGE = 50;
    private static final int HUNDRED_DAMAGE = 100;
    private static final int TWO_HUNDRED_DAMAGE = 200;

    private static final int ZERO_HEALTH = 0;
    private static final int FIFTY_HEALTH = 50;

    @Before
    public void setUp() {
        player = new Player(PLAYER_USERNAME, PLAYER_HEALTH);
        gun = new Gun(GUN_NAME, GUN_BULLETS);
        player.addGun(gun);
    }

    @Test(expected = NullPointerException.class)
    public void testShouldThrowExceptionForTryingToSetNullNameToPlayer() {
        new Player(NULL_NAME, PLAYER_HEALTH);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForTryingToSetInvalidHealthToPlayer() {
        new Player(PLAYER_USERNAME, INVALID_HEALTH);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testShouldThrowExceptionForTryingToModifyUnmodifiableCollection() {
        player.getGuns().clear();
    }

    @Test(expected = IllegalStateException.class)
    public void testShouldThrowExceptionWhenTryingToTakeDamageFromAlreadyDeadPlayer() {
        player.takeDamage(HUNDRED_DAMAGE);
        player.takeDamage(HUNDRED_DAMAGE);
    }

    @Test
    public void testShouldTakeDamageFromPlayerCorrectly() {
        player.takeDamage(FIFTY_DAMAGE);
        assertEquals(FIFTY_HEALTH, player.getHealth());

        player.takeDamage(TWO_HUNDRED_DAMAGE);
        int actualHealth = player.getHealth();
        assertEquals(ZERO_HEALTH, actualHealth);
    }

    @Test(expected = NullPointerException.class)
    public void testShouldThrowExceptionForTryingToAddNullGunToPlayer() {
        player.addGun(NULL_GUN);
    }

    @Test
    public void testShouldRemoveGunFromPlayerCorrectly() {
        boolean isRemoved = player.removeGun(gun);
        assertTrue(isRemoved);
    }

    @Test
    public void testShouldGetGunByGivenNameFromPlayerGunsCollection() {
        Gun gunByName = player.getGun(GUN_NAME);
        assertEquals(gun, gunByName);
    }

    @Test
    public void testShouldReturnPlayerUsernameCorrectly() {
        String username = player.getUsername();
        assertEquals(PLAYER_USERNAME, username);
    }
}
