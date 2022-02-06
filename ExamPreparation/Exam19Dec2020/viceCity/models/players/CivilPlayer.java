package M04_JavaOOP.ExamPreparation.Exam19Dec2020.viceCity.models.players;

public class CivilPlayer extends BasePlayer {
    private final static int LIFE_POINTS = 50;

    public CivilPlayer(String name) {
        super(name, LIFE_POINTS);
    }
}