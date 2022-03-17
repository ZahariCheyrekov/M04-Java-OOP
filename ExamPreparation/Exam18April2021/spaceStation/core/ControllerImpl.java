package M04_JavaOOP.ExamPreparation.Exam18April2021.spaceStation.core;

import M04_JavaOOP.ExamPreparation.Exam18April2021.spaceStation.common.ExceptionMessages;
import M04_JavaOOP.ExamPreparation.Exam18April2021.spaceStation.models.astronauts.Astronaut;
import M04_JavaOOP.ExamPreparation.Exam18April2021.spaceStation.models.astronauts.Biologist;
import M04_JavaOOP.ExamPreparation.Exam18April2021.spaceStation.models.astronauts.Geodesist;
import M04_JavaOOP.ExamPreparation.Exam18April2021.spaceStation.models.astronauts.Meteorologist;
import M04_JavaOOP.ExamPreparation.Exam18April2021.spaceStation.models.mission.Mission;
import M04_JavaOOP.ExamPreparation.Exam18April2021.spaceStation.models.mission.MissionImpl;
import M04_JavaOOP.ExamPreparation.Exam18April2021.spaceStation.models.planets.Planet;
import M04_JavaOOP.ExamPreparation.Exam18April2021.spaceStation.models.planets.PlanetImpl;
import M04_JavaOOP.ExamPreparation.Exam18April2021.spaceStation.repositories.AstronautRepository;
import M04_JavaOOP.ExamPreparation.Exam18April2021.spaceStation.repositories.PlanetRepository;
import M04_JavaOOP.ExamPreparation.Exam18April2021.spaceStation.repositories.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static M04_JavaOOP.ExamPreparation.Exam18April2021.spaceStation.common.ConstantMessages.*;
import static M04_JavaOOP.ExamPreparation.Exam18April2021.spaceStation.common.ConstantMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Astronaut> astronautRepository;
    private Repository<Planet> planetRepository;
    private int exploredPlanets;



    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut;

        switch (type) {
            case "Biologist":
                astronaut = new Biologist(astronautName);
                break;
            case "Geodesist":
                astronaut = new Geodesist(astronautName);
                break;
            case "Meteorologist":
                astronaut = new Meteorologist(astronautName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_INVALID_TYPE);
        }

        this.astronautRepository.add(astronaut);
        return String.format(ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);
        planet.getItems().addAll(Arrays.asList(items));
        this.planetRepository.add(planet);
        return String.format(PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut astronaut = this.astronautRepository.findByName(astronautName);

        if (astronaut == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }

        this.astronautRepository.remove(astronaut);
        return String.format(ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        List<Astronaut> suitableAstronauts = this.astronautRepository
                .getModels()
                .stream()
                .filter(astronaut -> astronaut.getOxygen() > 60)
                .collect(Collectors.toList());

        if (suitableAstronauts.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }

        Mission mission = new MissionImpl();
        Planet planet = this.planetRepository.findByName(planetName);
        mission.explore(planet, suitableAstronauts);
        exploredPlanets++;
        int astronautsAfterMission = mission.getDeadAstronauts();


        return String.format(PLANET_EXPLORED, planetName, astronautsAfterMission);
    }

   
}
