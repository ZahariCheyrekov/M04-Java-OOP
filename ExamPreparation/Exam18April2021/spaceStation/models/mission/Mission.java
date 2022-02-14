package M04_JavaOOP.ExamPreparation.Exam18April2021.spaceStation.models.mission;

import M04_JavaOOP.ExamPreparation.Exam18April2021.spaceStation.models.astronauts.Astronaut;
import M04_JavaOOP.ExamPreparation.Exam18April2021.spaceStation.models.planets.Planet;

import java.util.Collection;

public interface Mission {
    void explore(Planet planet, Collection<Astronaut> astronauts);

    int getDeadAstronauts();
}
