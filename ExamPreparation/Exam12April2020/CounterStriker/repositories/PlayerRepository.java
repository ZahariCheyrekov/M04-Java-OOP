package CounterStriker.repositories;

import CounterStriker.common.DataValidator;
import CounterStriker.models.players.Player;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import static CounterStriker.common.ExceptionMessages.INVALID_PLAYER_REPOSITORY;

public class PlayerRepository implements Repository<Player> {

    private Map<String, Player> players;

    public PlayerRepository() {
        this.players = new LinkedHashMap<>();
    }

    @Override
    public Collection<Player> getModels() {
        return Collections.unmodifiableCollection(this.players.values());
    }

    @Override
    public void add(Player model) {
        DataValidator.validatePlayer(model, INVALID_PLAYER_REPOSITORY);
        this.players.put(model.getUsername(), model);
    }

    @Override
    public boolean remove(Player model) {
        return this.players.remove(model.getUsername()) != null;
    }

    @Override
    public Player findByName(String name) {
        return this.players.get(name);
    }
}
