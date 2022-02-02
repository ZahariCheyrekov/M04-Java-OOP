package M04_JavaOOP.L07_ReflectionAndAnnotation.Exercises.T05BarracksWarsReturnOfTheDependencies.commands;

import M04_JavaOOP.L07_ReflectionAndAnnotation.Exercises.T05BarracksWarsReturnOfTheDependencies.Inject;
import jdk.jshell.spi.ExecutionControl;
import M04_JavaOOP.L07_ReflectionAndAnnotation.Exercises.T05BarracksWarsReturnOfTheDependencies.contracts.Repository;

import java.lang.reflect.InvocationTargetException;

public class ReportCommand extends Command {

    @Inject
    Repository repository;

    protected ReportCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() throws ClassNotFoundException, InvocationTargetException, InstantiationException, ExecutionControl.NotImplementedException, IllegalAccessException {
        return this.repository.getStatistics();
    }
}
