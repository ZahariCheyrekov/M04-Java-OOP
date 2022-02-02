package M04_JavaOOP.L04InterfacesAndAbstraction.Exercises.T06MilitaryElite;

public class Repair {
    private String partName;
    private int hoursWorked;

    public Repair(String partName, int hoursWorked) {
        setPartName(partName);
        setHoursWorked(hoursWorked);
    }

    public String getPartName() {
        return partName;
    }

    private void setPartName(String partName) {
        this.partName = partName;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    private void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String toString() {
        return String.format("Part Name: %s Hours Worked: %d", partName, hoursWorked);
    }
}