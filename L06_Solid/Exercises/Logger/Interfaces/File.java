package M04_JavaOOP.L06_Solid.Exercises.Logger.Interfaces;

public interface File {

    int getSize();

    boolean write(String text);

    void append(String text);
}