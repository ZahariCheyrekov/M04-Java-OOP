package M04_JavaOOP.L07_ReflectionAndAnnotation.Exercises.T05BarracksWarsReturnOfTheDependencies.commands;

import M04_JavaOOP.L07_ReflectionAndAnnotation.Exercises.T05BarracksWarsReturnOfTheDependencies.Inject;
import jdk.jshell.spi.ExecutionControl;
import M04_JavaOOP.L07_ReflectionAndAnnotation.Exercises.T05BarracksWarsReturnOfTheDependencies.contracts.Repository;

import java.lang.reflect.InvocationTargetException;
import java.security.InvalidParameterException;

public class RetireCommand extends Command {

    @Inject
    private Repository repository;

    protected RetireCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() throws ClassNotFoundException, InvocationTargetException, InstantiationException, ExecutionControl.NotImplementedException, IllegalAccessException {

        String unitType = super.getData()[1];
        try{
             this.repository.removeUnit(unitType);
         }
         catch (InvalidParameterException ex){
             return ex.getMessage();
         }
         return unitType+ " retired!";
    }
}
