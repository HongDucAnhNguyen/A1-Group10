package shapes;

public class Cylinder extends GeneralShape{
    private double radius;
    @Override
    public double calcVolume() {
        return 0;
    }

    public Cylinder(double height, double radius) {
        super(height);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double calcBaseArea() {
        return 0;
    }

    @Override
    public int compareTo(GeneralShape o) {
        return 0;
    }
}
