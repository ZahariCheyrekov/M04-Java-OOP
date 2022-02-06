package M04_JavaOOP.ExamPreparation.Exam19Dec2020.viceCity.core;

import M04_JavaOOP.ExamPreparation.Exam19Dec2020.viceCity.core.interfaces.Controller;
import M04_JavaOOP.ExamPreparation.Exam19Dec2020.viceCity.models.guns.Gun;
import M04_JavaOOP.ExamPreparation.Exam19Dec2020.viceCity.models.guns.Pistol;
import M04_JavaOOP.ExamPreparation.Exam19Dec2020.viceCity.models.guns.Rifle;
import M04_JavaOOP.ExamPreparation.Exam19Dec2020.viceCity.models.neighbourhood.GangNeighbourhood;
import M04_JavaOOP.ExamPreparation.Exam19Dec2020.viceCity.models.neighbourhood.Neighbourhood;
import M04_JavaOOP.ExamPreparation.Exam19Dec2020.viceCity.models.players.CivilPlayer;
import M04_JavaOOP.ExamPreparation.Exam19Dec2020.viceCity.models.players.MainPlayer;
import M04_JavaOOP.ExamPreparation.Exam19Dec2020.viceCity.models.players.Player;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static M04_JavaOOP.ExamPreparation.Exam19Dec2020.viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {
    private Player mainPlayer;
    private Map<String, Player> players;
    private ArrayDeque<Gun> guns;
    private Neighbourhood neighbourhood;

    public ControllerImpl() {
        this.mainPlayer = new MainPlayer();
        this.players = new LinkedHashMap<>();
        this.guns = new ArrayDeque<>();
        this.neighbourhood = new GangNeighbourhood();
    }

    @Override
    public String addPlayer(String name) {
        this.players.put(name, new CivilPlayer(name));
        return String.format(PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun;

        if (type.equals("Rifle")) {
            gun = new Rifle(name);

        } else if (type.equals("Pistol")) {
            gun = new Pistol(name);
        } else {
            return GUN_TYPE_INVALID;
        }

        this.guns.offer(gun);

        return String.format(GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String name) {
        Gun gun = this.guns.poll();

        if (gun == null) {
            return GUN_QUEUE_IS_EMPTY;
        }

        if (name.equals("Vercetti")) {
            mainPlayer.getGunRepository().add(gun);
            return String.format(GUN_ADDED_TO_MAIN_PLAYER, gun.getName(), mainPlayer.getName());
        }

        Player player = players.get(name);

        if (player == null) {
            return CIVIL_PLAYER_DOES_NOT_EXIST;
        }

        player.getGunRepository().add(gun);

        return String.format(GUN_ADDED_TO_CIVIL_PLAYER, gun.getName(), player.getName());
    }

    @Override
    public String fight() {
        this.neighbourhood.action(mainPlayer, players.values());

        if (this.mainPlayer.getLifePoints() == 100 && this.players
                .values()
                .stream()
                .allMatch(player -> player.getLifePoints() == 50)) {

            return FIGHT_HOT_HAPPENED;
        }

        List<Player> deadPlayers = this.players
                .values()
                .stream()
                .filter(player -> !player.isAlive())
                .collect(Collectors.toList());

        StringBuilder message = new StringBuilder(FIGHT_HAPPENED);

        message.append(System.lineSeparator())
                .append(String.format(MAIN_PLAYER_LIVE_POINTS_MESSAGE, mainPlayer.getLifePoints()))
                .append(System.lineSeparator())
                .append(String.format(MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, deadPlayers.size()))
                .append(System.lineSeparator())
                .append(String.format(CIVIL_PLAYERS_LEFT_MESSAGE, players.size() - deadPlayers.size()));

        for (Player player : deadPlayers) {
            players.remove(player.getName());
        }

        return message.toString().trim();
    }
}