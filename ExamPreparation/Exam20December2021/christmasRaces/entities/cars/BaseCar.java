package M04_JavaOOP.ExamPreparation.Exam20December2021.christmasRaces.entities.cars;

public abstract class BaseCar implements Car {
    private String model;
    private int horsePower;
    private double cubicCentimeters;

    public BaseCar(String model, int horsePower, double cubicCentimeters) {
        setModel(model);
        setHorsePower(horsePower);
        setCubicCentimeters(cubicCentimeters);
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getHorsePower() {
        return horsePower;
    }

    @Override
    public double getCubicCentimeters() {
        return cubicCentimeters;
    }

    protected void setModel(String model) {
        if (model.trim().length() < 4)
            throw new IllegalArgumentException(String.format(
                    "Model %s cannot be less than 4 symbols.", model));
        this.model = model;
    }

    protected void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    protected void setCubicCentimeters(double cubicCentimeters) {
        this.cubicCentimeters = cubicCentimeters;
    }

    public double calculateRacePoints(int laps) {
        return cubicCentimeters / horsePower * laps;
    }
}