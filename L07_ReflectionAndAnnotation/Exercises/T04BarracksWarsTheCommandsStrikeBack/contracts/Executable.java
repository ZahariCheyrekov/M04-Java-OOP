package M04_JavaOOP.L07_ReflectionAndAnnotation.Exercises.T04BarracksWarsTheCommandsStrikeBack.contracts;

import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

public interface Executable {

	String execute() throws ClassNotFoundException, InvocationTargetException, InstantiationException, ExecutionControl.NotImplementedException, IllegalAccessException;

}
