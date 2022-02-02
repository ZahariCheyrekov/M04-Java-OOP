package M04_JavaOOP.L08_ExceptionsAndErrorHandling.T03Fixing;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] weekdays = new String[5];

        int counter = 0;

        boolean finished = false;
        while (!finished) {

            try {
                System.out.println("Enter day number");
                int numDay = Integer.parseInt(scanner.nextLine());

                System.out.println("Enter name day");
                String dayName = scanner.nextLine();

                weekdays[numDay] = dayName;

                counter++;
                if (counter == 5) {
                    finished = true;
                }

            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("Enter numbers from 0 to 4");
            }
        }

        for (String day : weekdays) {
            System.out.println(day);
        }

    }
}