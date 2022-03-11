package M04_JavaOOP.L05_Polymorphism.Lab.T02Shapes;

public abstract class Shape {
  
    private Double perimeter;
    private Double area;

    protected abstract void calculatePerimeter();

    protected abstract void calculateArea();

    protected void setArea(Double area) {
        this.area = area;
    }

    protected void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }

    public Double getPerimeter() {
        if (perimeter == null) {
            calculatePerimeter();
        }
      
        return perimeter;
    }

    public Double getArea() {
        if (area == null) {
            calculateArea();
        }
      
        return area;
    }
}
