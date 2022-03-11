package M04_JavaOOP.L05_Polymorphism.Lab.T03Animals;

public abstract class Animal {
  
    private String name;
    private String favouriteFood;

    protected Animal(String name, String favouriteFood) {
        this.name = name;
        this.favouriteFood = favouriteFood;
    }

    public String explainSelf() {
        return "I am " + name + " and my favourite food is " + favouriteFood;
    }
}
