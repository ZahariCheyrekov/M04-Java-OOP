package M04_JavaOOP.ExamPreparation.Exam18April2021.spaceStation.models.mission;

import M04_JavaOOP.ExamPreparation.Exam18April2021.spaceStation.models.astronauts.Astronaut;
import M04_JavaOOP.ExamPreparation.Exam18April2021.spaceStation.models.planets.Planet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MissionImpl implements Mission {
    public static int deadAstronauts;

    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {
        List<Astronaut> astronautsExplore = astronauts.stream().filter(Astronaut::canBreath).collect(Collectors.toList());

        List<String> planetItems = new ArrayList<>(planet.getItems());

        for (int astronaut = 0; astronaut < astronautsExplore.size(); astronaut++) {
            Astronaut currentAstronaut = astronautsExplore.get(astronaut);

            for (int item = 0; item < planetItems.size(); item++) {
                String currentItem = planetItems.get(item);

                currentAstronaut.breath();
                currentAstronaut.getBag().getItems().add(currentItem);
                planetItems.remove(currentItem);

                item--;

                if (!currentAstronaut.canBreath()) {
                    astronautsExplore.remove(currentAstronaut);
                    deadAstronauts++;

                    astronaut--;
                    break;
                }
            }
        }
    }

    @Override
    public int getDeadAstronauts() {
        return deadAstronauts;
    }
}