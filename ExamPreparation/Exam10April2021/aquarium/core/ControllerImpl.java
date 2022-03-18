package aquarium.core;

import aquarium.entities.aquariums.Aquarium;
import aquarium.entities.aquariums.FreshwaterAquarium;
import aquarium.entities.aquariums.SaltwaterAquarium;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;
import aquarium.entities.decorations.Plant;
import aquarium.entities.fish.Fish;
import aquarium.entities.fish.FreshwaterFish;
import aquarium.entities.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;
import aquarium.repositories.Repository;

import java.util.ArrayList;
import java.util.List;

import static aquarium.common.ExceptionMessages.*;
import static aquarium.common.ConstantMessages.*;

public class ControllerImpl implements Controller {

    private Repository decorations;
    private List<Aquarium> aquariums;

    public ControllerImpl() {
        this.decorations = new DecorationRepository();
        this.aquariums = new ArrayList<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {

        Aquarium aquarium;

        switch (aquariumType) {
            case "FreshwaterAquarium":
                aquarium = new FreshwaterAquarium(aquariumName);
                break;
            case "SaltwaterAquarium":
                aquarium = new SaltwaterAquarium(aquariumName);
                break;
            default:
                throw new NullPointerException(INVALID_AQUARIUM_TYPE);
        }

        this.aquariums.add(aquarium);

        return String.format(SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
    }

    @Override
    public String addDecoration(String type) {
        Decoration decoration;

        switch (type) {
            case "Ornament":
                decoration = new Ornament();
                break;
            case "Plant":
                decoration = new Plant();
                break;
            default:
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

        Aquarium aquarium = getAquariumByName(aquariumName);

        aquarium.addDecoration(decoration);

        return String.format(SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM, decorationType, aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Fish fish;

        switch (fishType) {
            case "FreshwaterFish":
                fish = new FreshwaterFish(fishName, fishSpecies, price);
                break;
            case "SaltwaterFish":
                fish = new SaltwaterFish(fishName, fishSpecies, price);
                break;
            default:
                throw new IllegalArgumentException(INVALID_FISH_TYPE);
        }

        Aquarium aquarium = getAquariumByName(aquariumName);

        String aquariumType = aquarium.getClass().getSimpleName();

        boolean areSuitable = checkIfSuitable(fishType, aquariumType);

        if (!areSuitable) {
            return WATER_NOT_SUITABLE;
        }

        aquarium.addFish(fish);
        return String.format(SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fishType, aquariumName);
    }

    @Override
    public String feedFish(String aquariumName) {

        Aquarium aquarium = getAquariumByName(aquariumName);

        aquarium.getFish().forEach(Fish::eat);

        int fedFish = aquarium.getFish().size();

        return String.format(FISH_FED, fedFish);
    }

    @Override
    public String calculateValue(String aquariumName) {

        Aquarium aquarium = getAquariumByName(aquariumName);

        double decorationsPrice = calculateDecorationPrice(aquarium);
        double fishPrice = calculateFishPrice(aquarium);

        double totalPrice = decorationsPrice + fishPrice;

        return String.format(VALUE_AQUARIUM, aquariumName, totalPrice);
    }

    @Override
    public String report() {

        StringBuilder info = new StringBuilder();

        this.aquariums.forEach(aquarium -> info
                .append(aquarium.getInfo())
                .append(System.lineSeparator()));

        return info.toString().trim();
    }

    private Aquarium getAquariumByName(String aquariumName) {
        return this.aquariums
                .stream()
                .filter(a -> a.getName()
                        .equals(aquariumName))
                .findFirst()
                .orElse(null);
    }

    private boolean checkIfSuitable(String fishType, String aquariumType) {
        return (aquariumType.equals("FreshwaterAquarium"))
                && (fishType.equals("FreshwaterFish"))
                || (aquariumType.equals("SaltwaterAquarium"))
                && (fishType.equals("SaltwaterFish"));
    }

    private double calculateDecorationPrice(Aquarium aquarium) {
        return aquarium.
                getDecorations()
                .stream()
                .mapToDouble(Decoration::getPrice)
                .sum();
    }

    private double calculateFishPrice(Aquarium aquarium) {
        return aquarium
                .getFish()
                .stream()
                .mapToDouble(Fish::getPrice)
                .sum();
    }
}
