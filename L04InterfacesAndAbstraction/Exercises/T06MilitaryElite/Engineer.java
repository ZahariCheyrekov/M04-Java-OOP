package M04_JavaOOP.L04InterfacesAndAbstraction.Exercises.T06MilitaryElite;

import java.util.Collection;

public interface Engineer extends SpecialisedSoldier {
    void addRepair(Repair repair);
    Collection<Repair> getRepairs();
}