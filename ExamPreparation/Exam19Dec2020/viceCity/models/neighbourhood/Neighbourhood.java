package M04_JavaOOP.ExamPreparation.Exam19Dec2020.viceCity.models.neighbourhood;

import M04_JavaOOP.ExamPreparation.Exam19Dec2020.viceCity.models.players.Player;

import java.util.Collection;

public interface Neighbourhood {
    void action(Player mainPlayer, Collection<Player> civilPlayers);
}
