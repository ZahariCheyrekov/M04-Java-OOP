package M04_JavaOOP.L04InterfacesAndAbstraction.Exercises.T06MilitaryElite;

public abstract class SoldierImpl implements Soldier {
    private int id;
    private String firstName, lastName;

    public SoldierImpl(int id, String firstName, String lastName) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }
}