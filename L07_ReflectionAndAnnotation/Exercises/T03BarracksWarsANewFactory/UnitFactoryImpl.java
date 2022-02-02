package M04_JavaOOP.L07_ReflectionAndAnnotation.Exercises.T03BarracksWarsANewFactory;

import jdk.jshell.spi.ExecutionControl;
import M04_JavaOOP.L07_ReflectionAndAnnotation.Exercises.T03BarracksWarsANewFactory.Interfaces.Unit;
import M04_JavaOOP.L07_ReflectionAndAnnotation.Exercises.T03BarracksWarsANewFactory.Interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"pr0304Barracks.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
		Class cl = Class.forName(UNITS_PACKAGE_NAME + unitType);

		Constructor<?> constructor = cl.getConstructors()[0];
		constructor.setAccessible(true);
		Unit unit  = (Unit)constructor.newInstance();

		return unit;

	}
}
