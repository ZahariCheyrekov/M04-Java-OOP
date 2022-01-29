package M04_JavaOOP.L01_Abstraction.Lab;

import java.util.Scanner;

public class T01RhombusOfStars {
    public static StringBuilder output = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        printFigure(n);
    }

    private static void printFigure(int n) {
        getTop(n);
        getMiddle(n);
        getBottom(n);

        System.out.print(output);
    }

    private static void getTop(int n) {
        for (int i = 0; i < n; i++) {
            appendSpaces(n - i);
            appendStars(i);
            output.append(System.lineSeparator());
        }
    }

    private static void appendSpaces(int size) {
        for (int j = 0; j < size; j++) {
            output.append(" ");
        }
    }

    private static void appendStars(int size) {
        for (int j = 0; j < size; j++) {
            output.append("* ");
        }
    }

    private static void getMiddle(int n) {
        appendStars(n);
        output.append(System.lineSeparator());
    }

    private static void getBottom(int n) {
        for (int i = 1; i < n; i++) {
            appendSpaces(i);
            appendStars(n - i);
            output.append(System.lineSeparator());
        }
    }
}