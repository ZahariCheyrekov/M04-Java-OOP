package M04_JavaOOP.L07_ReflectionAndAnnotation.Exercises.T04BarracksWarsTheCommandsStrikeBack.core.commands;

import jdk.jshell.spi.ExecutionControl;
import M04_JavaOOP.L07_ReflectionAndAnnotation.Exercises.T04BarracksWarsTheCommandsStrikeBack.contracts.Repository;
import M04_JavaOOP.L07_ReflectionAndAnnotation.Exercises.T04BarracksWarsTheCommandsStrikeBack.contracts.UnitFactory;

import java.lang.reflect.InvocationTargetException;
import java.security.InvalidParameterException;

public class RetireCommand extends Command {
    protected RetireCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() throws ClassNotFoundException, InvocationTargetException, InstantiationException, ExecutionControl.NotImplementedException, IllegalAccessException {

        String unitType = super.getData()[1];
        try{
             super.getRepository().removeUnit(unitType);
         }
         catch (InvalidParameterException ex){
             return ex.getMessage();
         }
         return unitType+ " retired!";
    }
}
