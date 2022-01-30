package M04_JavaOOP.L01_Abstraction.Exercises.T03CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RankPowers cardRank = RankPowers.valueOf(scanner.nextLine());
        SuitPowers suitPowers = SuitPowers.valueOf(scanner.nextLine());

        Card card = new Card(cardRank, suitPowers);

        System.out.printf("Card name: %s of %s; Card power: %d%n", cardRank, suitPowers, card.getPower());
    }
}