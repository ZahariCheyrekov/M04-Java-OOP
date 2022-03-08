import java.util.Scanner;

public class T01RhombusOfStars {
    private static final StringBuilder output=new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        printFigure(size);
    }

    private static void printFigure(int size) {
        getTop(size);
        getMiddle(size);
        getBottom(size);

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
        output.append(" ".repeat(Math.max(0, size)));
    }

    private static void appendStars(int size) {
        output.append("* ".repeat(Math.max(0, size)));
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
