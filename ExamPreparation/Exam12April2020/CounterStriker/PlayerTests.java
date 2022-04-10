


public class PlayerTests {

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
