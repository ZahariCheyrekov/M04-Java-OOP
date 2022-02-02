package M04_JavaOOP.L07_ReflectionAndAnnotation.Exercises.T05BarracksWarsReturnOfTheDependencies.contracts;

import jdk.jshell.spi.ExecutionControl;

public interface Repository {

	void addUnit(Unit unit);

	String getStatistics();

	void removeUnit(String unitType) throws ExecutionControl.NotImplementedException;
}
