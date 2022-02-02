package M04_JavaOOP.L06_Solid.Exercises.Logger.Interfaces;

public interface Factory<T> {
    T produce(String input);
}