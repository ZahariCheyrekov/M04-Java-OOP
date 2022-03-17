package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MissionImpl implements Mission {

    private int deadAstronauts;

    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {

        List<Astronaut> astronautsExplore = new ArrayList<>(astronauts);

        List<String> planetItems = new ArrayList<>(planet.getItems());


        for (int index = 0; index < astronautsExplore.size(); index++) {
            Astronaut astronaut = astronautsExplore.get(index);

            for (int item = 0; item < planetItems.size(); item++) {
                String currentItem = planetItems.get(item);

                astronaut.breath();
                astronaut.getBag().getItems().add(currentItem);
                planetItems.remove(item);

                item--;

                if (!astronaut.canBreath()) {
                    deadAstronauts++;
                    break;
                }
            }
        }
    }

    @Override
    public int getDeadAstronauts() {
        return this.deadAstronauts;
    }
}
