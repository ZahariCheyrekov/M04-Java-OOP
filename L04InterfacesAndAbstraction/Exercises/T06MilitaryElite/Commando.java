package M04_JavaOOP.L04InterfacesAndAbstraction.Exercises.T06MilitaryElite;

import java.util.Collection;

public interface Commando extends SpecialisedSoldier{
    void addMission(Mission mission);
    Collection<Mission> getMissions();
}