package shapes;

public class Cone extends GeneralShape{
private double radius;
    @Override
    public double calcVolume() {
        return 0;
    }

    public Cone(double height, double radius) {
        super(height);
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

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
