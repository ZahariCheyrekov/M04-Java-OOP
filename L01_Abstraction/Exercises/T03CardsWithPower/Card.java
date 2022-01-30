package M04_JavaOOP.L01_Abstraction.Exercises.T03CardsWithPower;

public class Card {
    private RankPowers rankPowers;
    private SuitPowers suitPowers;

    public Card(RankPowers rankPowers, SuitPowers suitPowers) {
        this.rankPowers = rankPowers;
        this.suitPowers = suitPowers;
    }

    public int getPower() {
        return rankPowers.getRankPower() + suitPowers.getSuitPower();
    }
}