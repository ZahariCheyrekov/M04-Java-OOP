package M04_JavaOOP.L01_Abstraction.Exercises.T05JediGalaxy;

import java.util.Scanner;

public class ConsoleReader {
    private Scanner scanner;

    public ConsoleReader() {
        this.scanner = new Scanner(System.in);
    }

    public String readLine() {
        return this.scanner.nextLine();
    }
}
