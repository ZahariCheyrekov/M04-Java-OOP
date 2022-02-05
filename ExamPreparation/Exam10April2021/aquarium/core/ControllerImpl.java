package M04_JavaOOP.ExamPreparation.Exam10April2021.aquarium.core;

import M04_JavaOOP.ExamPreparation.Exam10April2021.aquarium.entities.aquariums.Aquarium;
import M04_JavaOOP.ExamPreparation.Exam10April2021.aquarium.entities.aquariums.FreshwaterAquarium;
import M04_JavaOOP.ExamPreparation.Exam10April2021.aquarium.entities.aquariums.SaltwaterAquarium;
import M04_JavaOOP.ExamPreparation.Exam10April2021.aquarium.entities.decorations.Decoration;
import M04_JavaOOP.ExamPreparation.Exam10April2021.aquarium.entities.decorations.Ornament;
import M04_JavaOOP.ExamPreparation.Exam10April2021.aquarium.entities.decorations.Plant;
import M04_JavaOOP.ExamPreparation.Exam10April2021.aquarium.entities.fish.Fish;
import M04_JavaOOP.ExamPreparation.Exam10April2021.aquarium.entities.fish.FreshwaterFish;
import M04_JavaOOP.ExamPreparation.Exam10April2021.aquarium.entities.fish.SaltwaterFish;
import M04_JavaOOP.ExamPreparation.Exam10April2021.aquarium.repositories.DecorationRepository;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static M04_JavaOOP.ExamPreparation.Exam10April2021.aquarium.common.ConstantMessages.*;
import static M04_JavaOOP.ExamPreparation.Exam10April2021.aquarium.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private DecorationRepository decorations;
    private Map<String, Aquarium> aquariums;

    public ControllerImpl() {
        this.decorations = new DecorationRepository();
        this.aquariums = new LinkedHashMap<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        Aquarium aquarium;

        if (aquariumType.equals("FreshwaterAquarium")) {
            aquarium = new FreshwaterAquarium(aquariumName);

        } else if (aquariumType.equals("SaltwaterAquarium")) {
            aquarium = new SaltwaterAquarium(aquariumName);

        } else {
            throw new NullPointerException(INVALID_AQUARIUM_TYPE);
        }

        this.aquariums.put(aquarium.getName(), aquarium);

        return String.format(SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
    }

    @Override
    public String addDecoration(String type) {
        Decoration decoration;

        if (type.equals("Ornament")) {
            decoration = new Ornament();

        } else if (type.equals("Plant")) {
            decoration = new Plant();

        } else {
            throw new IllegalArgumentException(INVALID_DECORATION_TYPE);
        }

        this.decorations.add(decoration);

        return String.format(SUCCESSFULLY_ADDED_DECORATION_TYPE, type);
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        Decoration decoration = this.decorations.findByType(decorationType);

        if (decoration == null) {
            throw new IllegalArgumentException(String.format(NO_DECORATION_FOUND, decorationType));
        }

        this.decorations.remove(decoration);

        aquariums.get(aquariumName).addDecoration(decoration);

        return String.format(SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM, decorationType, aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Fish fish;

        if (fishType.equals("FreshwaterFish")) {
            fish = new FreshwaterFish(fishName, fishSpecies, price);

        } else if (fishType.equals("SaltwaterFish")) {
            fish = new SaltwaterFish(fishName, fishSpecies, price);

        } else {
            throw new IllegalArgumentException(INVALID_FISH_TYPE);
        }

        try {
            Aquarium aquarium = this.aquariums.get(aquariumName);
            aquarium.addFish(fish);

        } catch (IllegalStateException ex) {
            return ex.getMessage();
        }

        return String.format(SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fishType, aquariumName);
    }

    @Override
    public String feedFish(String aquariumName) {
        Aquarium aquarium = this.aquariums.get(aquariumName);
        aquarium.feed();

        return String.format(FISH_FED, aquarium.getFish().size());
    }

    @Override
    public String calculateValue(String aquariumName) {
        Aquarium aquarium = aquariums.get(aquariumName);

        double value = aquarium
                .getFish()
                .stream()
                .mapToDouble(Fish::getPrice)
                .sum() + aquarium
                .getDecorations()
                .stream()
                .mapToDouble(Decoration::getPrice)
                .sum();

        return String.format(VALUE_AQUARIUM, aquariumName, value);
    }

    @Override
    public String report() {
        return this.aquariums
                .values()
                .stream()
                .map(Aquarium::getInfo)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}