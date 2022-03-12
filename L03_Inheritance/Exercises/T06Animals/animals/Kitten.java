package M04_JavaOOP.L03_Inheritance.Exercises.T06Animals.animals;

public class Kitten extends Cat {
   
    private static final String GENDER = "Female";

    public Kitten(String name, int age) {
        super(name, age, GENDER);
    }

    public Kitten(String name, int age, String gender) {
        super(name, age, GENDER);
    }

    @Override
    public String produceSound() {
        return "Meow";
    }
}
