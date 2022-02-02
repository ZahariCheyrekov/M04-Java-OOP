package M04_JavaOOP.L05_Polymorphism.Lab.T03Animals;

public class Dog extends Animal {
    public Dog(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        return super.explainSelf() + System.lineSeparator() + "DJAAF";
    }
}