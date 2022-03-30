package CounterStriker.core;

import CounterStriker.models.field.Field;
import CounterStriker.models.field.FieldImpl;
import CounterStriker.models.guns.Gun;
import CounterStriker.models.guns.Pistol;
import CounterStriker.models.guns.Rifle;
import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;
import CounterStriker.repositories.GunRepository;
import CounterStriker.repositories.PlayerRepository;
import CounterStriker.repositories.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static CounterStriker.common.ExceptionMessages.*;
import static CounterStriker.common.OutputMessages.*;

public class ControllerImpl implements Controller {

    private Repository<Gun> guns;
    private Repository<Player> players;
    private Field field;

    private static final int EQUAL_RESULT = 0;

    public ControllerImpl() {
        this.guns = new GunRepository();
        this.players = new PlayerRepository();
        this.field = new FieldImpl();
    }

    @Override
    public String addGun(String type, String name, int bulletsCount) {
        Gun gun;

        switch (type) {
            case "Pistol":
                gun = new Pistol(name, bulletsCount);
                break;
            case "Rifle":
                gun = new Rifle(name, bulletsCount);
                break;
            default:
                throw new IllegalArgumentException(INVALID_GUN_TYPE);
        }

        this.guns.add(gun);
        return String.format(SUCCESSFULLY_ADDED_GUN, name);
    }

    @Override
    public String addPlayer(String type, String username, int health, int armor, String gunName) {
        Gun gun = this.guns.findByName(gunName);

        if (gun == null) {
            throw new NullPointerException(GUN_CANNOT_BE_FOUND);
        }

        Player player;

        switch (type) {
            case "CounterTerrorist":
                player = new CounterTerrorist(username, health, armor, gun);
                break;
            case "Terrorist":
                player = new Terrorist(username, health, armor, gun);
                break;
            default:
                throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }

        this.players.add(player);
        return String.format(SUCCESSFULLY_ADDED_PLAYER, username);
    }

    @Override
    public String startGame() {
        List<Player> alivePlayers = this.players
                .getModels()
                .stream()
                .filter(Player::isAlive)
                .collect(Collectors.toList());

        String resultAfterBattle = this.field.start(alivePlayers);

        return resultAfterBattle;
    }

    @Override
    public String report() {
        StringBuilder info = new StringBuilder();


        this.players.getModels().stream().sorted((first, second) -> {

                    int result = first
                            .getClass()
                            .getSimpleName()
                            .compareTo(second.getClass()
                                    .getSimpleName());

                    if (result == EQUAL_RESULT) {
                        result = Integer.compare(second.getHealth(), first.getHealth());
                    }

                    if (result == EQUAL_RESULT) {
                        result = first.getUsername().compareTo(second.getUsername());
                    }

                    return result;
                })
                .forEach(player -> info
                        .append(player)
                        .append(System.lineSeparator()));

        return info.toString().trim();
    }
}
