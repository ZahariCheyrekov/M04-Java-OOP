


public class PlayerTests {


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
