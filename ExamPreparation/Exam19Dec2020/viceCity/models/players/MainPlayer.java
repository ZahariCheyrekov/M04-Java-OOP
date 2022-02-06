package M04_JavaOOP.ExamPreparation.Exam19Dec2020.viceCity.models.players;

public class MainPlayer extends BasePlayer {
    private final static int LIFE_POINTS = 100;
    private final static String NAME = "Tommy Vercetti";

    public MainPlayer() {
        super(NAME, LIFE_POINTS);
    }
}