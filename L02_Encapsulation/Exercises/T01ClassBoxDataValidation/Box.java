package M04_JavaOOP.L02_Encapsulation.Exercises.T01ClassBoxDataValidation;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    public void setLength(double length) {
        checkIfValid(length, "Length");
        this.length = length;
    }

    public void setWidth(double width) {
        checkIfValid(width, "Width");
        this.width = width;
    }

    public void setHeight(double height) {
        checkIfValid(height, "Height");
        this.height = height;
    }

    private void checkIfValid(double size, String parameter) {
        if (size <= 0) {
            throw new IllegalArgumentException(parameter + " cannot be zero or negative.");
        }
    }

    public double calculateSurfaceArea() {
        return 2 * ((length * width) + (length * height) + (width * height));
    }

    public double calculateLateralSurfaceArea() {
        return 2 * ((length * height) + (width * height));
    }

    public double calculateVolume() {
        return length * width * height;
    }
}