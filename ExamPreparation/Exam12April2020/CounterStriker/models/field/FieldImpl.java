package CounterStriker.models.field;

import CounterStriker.models.players.Player;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static CounterStriker.common.OutputMessages.*;

public class FieldImpl implements Field {

    private static final String TERRORISTS = "Terrorist";
    private static final String COUNTER_TERRORISTS = "CounterTerrorist";

    private static final int EMPTY_COLLECTION_SIZE = 0;

    @Override
    public String start(Collection<Player> players) {

        List<Player> terrorists = players
                .stream()
                .filter(player -> player.getClass()
                        .getSimpleName().equals(TERRORISTS))
                .collect(Collectors.toList());

        List<Player> counterTerrorists = players
                .stream()
                .filter(player -> player.getClass()
                        .getSimpleName().equals(COUNTER_TERRORISTS))
                .collect(Collectors.toList());

        while (!terrorists.isEmpty() && !counterTerrorists.isEmpty()) {

            for (Player terrorist : terrorists) {
                for (int ct = 0; ct < counterTerrorists.size(); ct++) {
                    Player counterTerrorist = counterTerrorists.get(ct);

                    int fireDamage = terrorist.getGun().fire();

                    counterTerrorist.takeDamage(fireDamage);

                    if (!counterTerrorist.isAlive()) {
                        counterTerrorists.remove(counterTerrorist);
                        ct--;
                    }
                }
            }

            for (Player counterTerrorist : counterTerrorists) {
                for (int t = 0; t < terrorists.size(); t++) {
                    Player terrorist = terrorists.get(t);

                    int fireDamage = counterTerrorist.getGun().fire();

                    terrorist.takeDamage(fireDamage);

                    if (!terrorist.isAlive()) {
                        terrorists.remove(terrorist);
                        t--;
                    }
                }
            }
        }

        String winner = terrorists.size() > EMPTY_COLLECTION_SIZE
                ? TERRORIST_WINS
                : COUNTER_TERRORIST_WINS;

        return winner;
    }
}
