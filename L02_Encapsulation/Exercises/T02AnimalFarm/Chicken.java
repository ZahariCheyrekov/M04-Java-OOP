package M04_JavaOOP.L02_Encapsulation.Exercises.T02AnimalFarm;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() < 2) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    private double calculateProductPerDay() {
        if (age >= 0 && age < 6) {
            return 2;
        } else if (age >= 6 && age < 12) {
            return 1;
        } else {
            return 0.75;
        }
    }

    public double productPerDay() {
        return calculateProductPerDay();
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.",
                this.getName(), this.getAge(), this.productPerDay());
    }
}