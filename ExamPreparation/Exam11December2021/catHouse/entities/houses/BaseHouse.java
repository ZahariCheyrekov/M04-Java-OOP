package catHouse.entities.houses;

        if (cats.size() == 0) {
            stats.append("Cats: none").append(System.lineSeparator());
        } else {
            stats.append("Cats:");

            for (Cat cat : cats) {
                stats.append(CATS_NAMES_DELIMITER).append(cat.getName());
            }

            stats.append(System.lineSeparator());
        }

        int toysCount = toys.size();
        int sumOfSoftness = toys.stream().mapToInt(Toy::getSoftness).sum();

        stats.append(String.format(TOYS_COUNT_ADN_SOFTNESS_TO_STRING, toysCount, sumOfSoftness))
                .append(System.lineSeparator());

        return stats.toString().trim();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Collection<Cat> getCats() {
        return this.cats;
    }

    @Override
    public Collection<Toy> getToys() {
        return this.toys;
    }
}
