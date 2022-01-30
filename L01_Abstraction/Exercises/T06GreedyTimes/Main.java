package M04_JavaOOP.L01_Abstraction.Exercises.T06GreedyTimes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long capacity = Long.parseLong(scanner.nextLine());

        String[] input = scanner.nextLine().split("\\s+");

        Bag bag = new Bag(capacity);

        fillBag(bag, input);

        System.out.println(bag);
    }

    private static void fillBag(Bag bag, String[] input) {
        for (int i = 0; i < input.length; i += 2) {
            String name = input[i];
            long amount = Long.parseLong(input[i + 1]);

            if (name.length() == 3) {
                Cash cash = new Cash(name, amount);
                bag.addCash(cash);

            } else if (name.toLowerCase().endsWith("gem")) {
                Gem gem = new Gem(name, amount);
                bag.addGem(gem);

            } else if (name.equalsIgnoreCase("gold")) {
                Gold gold = new Gold(name, amount);
                bag.addGold(gold);
            }
        }
    }
}