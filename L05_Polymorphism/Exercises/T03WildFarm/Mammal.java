package M04_JavaOOP.L05_Polymorphism.Exercises.T03WildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {
    private String livingRegion;

    public Mammal(String name, String type, double weight, String livingRegion) {
        super(name, type, weight);
        this.livingRegion = livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        return String.format("%s[%s, %s, %s, %d]", getType(), getName(),
                decimalFormat.format(getWeight()), this.livingRegion, getFoodEaten());
    }

    public String getLivingRegion() {
        return livingRegion;
    }
}