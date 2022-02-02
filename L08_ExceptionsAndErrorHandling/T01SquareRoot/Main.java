package M04_JavaOOP.L08_ExceptionsAndErrorHandling.T01SquareRoot;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int number = Integer.parseInt(scanner.nextLine());
            System.out.println(Math.sqrt(number));

        } catch (NumberFormatException ex) {
            throw new NumberFormatException("Invalid number");

        } finally {
            System.out.println("Good bye");
        }
    }
}