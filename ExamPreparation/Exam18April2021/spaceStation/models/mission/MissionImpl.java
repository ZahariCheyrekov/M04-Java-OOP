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

        List<Astronaut> astronautList = new ArrayList<>(astronauts);
        List<String> planetItems = new ArrayList<>(planet.getItems());

        for (int ast = 0; ast < astronautList.size(); ast++) {
            Astronaut astronaut = astronautList.get(ast);

            for (int itm = 0; itm < planetItems.size(); itm++) {
                String item = planetItems.get(itm);

                astronaut.breath();
                astronaut.getBag().getItems().add(item);
                planetItems.remove(itm);

                itm--;

                if (!astronaut.canBreath()) {
                    this.deadAstronauts++;
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
