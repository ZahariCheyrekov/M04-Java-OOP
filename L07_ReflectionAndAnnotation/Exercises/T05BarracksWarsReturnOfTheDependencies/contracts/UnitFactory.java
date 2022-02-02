package M04_JavaOOP.L07_ReflectionAndAnnotation.Exercises.T05BarracksWarsReturnOfTheDependencies.contracts;

import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

public interface UnitFactory {

    Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException;
}