

public class ControllerImpl implements Controller {


    public String addArea(String areaType, String areaName) {


        this.areas.put(areaName, area);
        return String.format(SUCCESSFULLY_ADDED_AREA_TYPE, areaType);
    }

    @Override
    public String buyFood(String type) {
        Food food;

        switch (type) {
            case "Vegetable":
                food = new Vegetable();
                break;
            case "Meat":
                food = new Meat();
                break;
            default:
                throw new IllegalArgumentException(INVALID_FOOD_TYPE);
        }

        this.foodRepository.add(food);
        return String.format(SUCCESSFULLY_ADDED_FOOD_TYPE, type);
    }

    @Override
    public String foodForArea(String areaName, String foodType) {
        Food food = this.foodRepository.findByType(foodType);

        if (food == null) {
            throw new IllegalArgumentException(String.format(NO_FOOD_FOUND, foodType));
        }

        Area area = this.areas.get(areaName);
        area.addFood(food);
        this.foodRepository.remove(food);

        return String.format(SUCCESSFULLY_ADDED_FOOD_IN_AREA, foodType, areaName);
    }

    @Override
    public String addAnimal(String areaName, String animalType, String animalName, String kind, double price) {
        Animal animal;

        switch (animalType) {
            case "AquaticAnimal":
                animal = new AquaticAnimal(animalName, kind, price);
                break;
            case "TerrestrialAnimal":
                animal = new TerrestrialAnimal(animalName, kind, price);
                break;
            default:
                throw new IllegalArgumentException(INVALID_ANIMAL_TYPE);
        }

        Area area = this.areas.get(areaName);
        String areaType = area.getClass().getSimpleName();

        boolean areSuitable = ((areaType.equals("WaterArea") && animalType.equals("AquaticAnimal"))
                || (areaType.equals("LandArea") && animalType.equals("TerrestrialAnimal")));

        if (!areSuitable) {
            return AREA_NOT_SUITABLE;
        }

        area.addAnimal(animal);
        return String.format(SUCCESSFULLY_ADDED_ANIMAL_IN_AREA, animalType, areaName);
    }

    @Override
    public String feedAnimal(String areaName) {
        Area area = this.areas.get(areaName);
        area.feed();

        return String.format(ANIMAL_FED, area.getAnimal().size());
    }

    @Override
    public String calculateKg(String areaName) {
        Area area = this.areas.get(areaName);
        double animalsKG = area
                .getAnimal()
                .stream()
                .mapToDouble(Animal::getKg)
                .sum();

        return String.format(KILOGRAMS_AREA, areaName, animalsKG);
    }

    @Override
    public String getStatistics() {
        StringBuilder stats = new StringBuilder();

        for (Area area : this.areas.values()) {
           stats.append(area.getInfo()).append(System.lineSeparator());
        }

        return stats.toString().trim();
    }
}
