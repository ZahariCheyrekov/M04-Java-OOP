package catHouse.entities.houses;

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
