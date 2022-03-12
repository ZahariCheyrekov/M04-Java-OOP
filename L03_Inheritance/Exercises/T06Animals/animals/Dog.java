package M04_JavaOOP.L03_Inheritance.Exercises.T06Animals.animals;

public class Dog extends Animal {
  
    public Dog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "Woof!";
    }
}
