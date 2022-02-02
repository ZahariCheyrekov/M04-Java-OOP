package M04_JavaOOP.L04InterfacesAndAbstraction.Exercises.T05Telephony;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> numbers = readData(scanner);
        List<String> urls = readData(scanner);

        Smartphone smartphone = new Smartphone(numbers, urls);

        System.out.print(smartphone.call());
        System.out.print(smartphone.browse());
    }

    private static List<String> readData(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("[\\s]+"))
                .collect(Collectors.toList());
    }
}