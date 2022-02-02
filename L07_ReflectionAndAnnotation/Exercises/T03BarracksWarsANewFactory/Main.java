package M04_JavaOOP.L07_ReflectionAndAnnotation.Exercises.T03BarracksWarsANewFactory;


import M04_JavaOOP.L07_ReflectionAndAnnotation.Exercises.T03BarracksWarsANewFactory.Interfaces.Repository;
import M04_JavaOOP.L07_ReflectionAndAnnotation.Exercises.T03BarracksWarsANewFactory.Interfaces.Runnable;
import M04_JavaOOP.L07_ReflectionAndAnnotation.Exercises.T03BarracksWarsANewFactory.Interfaces.UnitFactory;

public class Main {

	public static void main(String[] args) {
		Repository repository = new UnitRepository();
		UnitFactory unitFactory = new UnitFactoryImpl();
		Runnable engine = new Engine(repository, unitFactory);
		engine.run();
	}
}
