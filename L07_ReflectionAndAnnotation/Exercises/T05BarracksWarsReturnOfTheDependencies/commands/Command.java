package M04_JavaOOP.L07_ReflectionAndAnnotation.Exercises.T05BarracksWarsReturnOfTheDependencies.commands;

import M04_JavaOOP.L07_ReflectionAndAnnotation.Exercises.T05BarracksWarsReturnOfTheDependencies.contracts.Executable;

public abstract class Command implements Executable {
    private String[] data;


    protected Command(String[] data) {
        this.data = data;
    }

    protected String[] getData() {
        return data;
    }


}
