package M04_JavaOOP.L04InterfacesAndAbstraction.Exercises.T04FoodShortage;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Buyer> buyers = new HashMap<>();

        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= numberOfPeople; i++) {
            String[] info = scanner.nextLine().split("[\\s]+");

            if (info.length == 4) {
                addCitizen(info, buyers);

            } else {
                addRebel(info, buyers);
            }
        }

        String name = scanner.nextLine();
        while (!name.equals("End")) {

            if (buyers.containsKey(name)) {
                Buyer buyer = buyers.get(name);
                buyer.buyFood();
            }

            name = scanner.nextLine();
        }

        int foodPurchased = buyers
                .values()
                .stream()
                .mapToInt(Buyer::getFood)
                .sum();

        System.out.println(foodPurchased);
    }

    private static void addCitizen(String[] info, Map<String, Buyer> buyers) {
        String name = info[0];
        int age = Integer.parseInt(info[1]);
        String id = info[2];
        String birthdate = info[3];

        Citizen citizen = new Citizen(name, age, id, birthdate);
        buyers.put(name, citizen);
    }

    private static void addRebel(String[] info, Map<String, Buyer> buyers) {
        String name = info[0];
        int age = Integer.parseInt(info[1]);
        String group = info[2];

        Rebel rebel = new Rebel(name, age, group);
        buyers.put(name, rebel);
    }
}