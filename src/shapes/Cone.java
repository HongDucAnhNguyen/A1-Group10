package shapes;

public class Cone extends GeneralShape{
private double radius;
    public Cone(double height, double radius) {
        this.height = height;
        this.radius = radius;
    }
    public double calcVolume() {
        return (1/3) * PI * Math.pow(getRadius(), 2) * getHeight();
    }

    @Override
    public double calcBaseArea() {
        return PI * Math.pow(radius, 2);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
