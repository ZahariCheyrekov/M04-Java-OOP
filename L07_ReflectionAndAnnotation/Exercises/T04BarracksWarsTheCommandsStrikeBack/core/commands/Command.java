package M04_JavaOOP.L07_ReflectionAndAnnotation.Exercises.T04BarracksWarsTheCommandsStrikeBack.core.commands;

import M04_JavaOOP.L07_ReflectionAndAnnotation.Exercises.T04BarracksWarsTheCommandsStrikeBack.contracts.Executable;
import M04_JavaOOP.L07_ReflectionAndAnnotation.Exercises.T04BarracksWarsTheCommandsStrikeBack.contracts.Repository;
import M04_JavaOOP.L07_ReflectionAndAnnotation.Exercises.T04BarracksWarsTheCommandsStrikeBack.contracts.UnitFactory;

public abstract class Command implements Executable {
    private String[] data;
    private Repository repository;
    private UnitFactory unitFactory;

    protected Command(String[] data, Repository repository, UnitFactory unitFactory) {
        this.data = data;
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    protected String[] getData() {
        return data;
    }

    protected Repository getRepository() {
        return repository;
    }

    protected UnitFactory getUnitFactory() {
        return unitFactory;
    }
}
