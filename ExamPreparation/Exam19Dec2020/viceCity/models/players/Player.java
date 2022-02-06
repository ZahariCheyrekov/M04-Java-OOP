package M04_JavaOOP.ExamPreparation.Exam19Dec2020.viceCity.models.players;

import M04_JavaOOP.ExamPreparation.Exam19Dec2020.viceCity.models.guns.Gun;
import M04_JavaOOP.ExamPreparation.Exam19Dec2020.viceCity.repositories.interfaces.Repository;

public interface Player {
    String getName();

    int getLifePoints();

    boolean isAlive();

    Repository<Gun> getGunRepository();

    void takeLifePoints(int points);
}
