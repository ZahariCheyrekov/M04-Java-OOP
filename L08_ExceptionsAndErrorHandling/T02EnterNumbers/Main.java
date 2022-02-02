package M04_JavaOOP.L08_ExceptionsAndErrorHandling.T02EnterNumbers;


import java.util.Scanner;

public class Main {
    public static boolean hasEnded = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (!hasEnded) {
            try {
                int start = Integer.parseInt(scanner.nextLine());
                int end = Integer.parseInt(scanner.nextLine());

                printNumbers(start, end);

            } catch (NumberFormatException ex) {
                System.out.println("Enter two integer numbers");
            }
        }

        System.out.println("Congratulations!");
    }

    private static void printNumbers(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.println(i);
        }
        hasEnded = true;
    }
}