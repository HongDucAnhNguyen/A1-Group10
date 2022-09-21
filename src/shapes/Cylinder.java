package shapes;

public class Cylinder extends GeneralShape{
    private double radius;
    public double calcVolume() {
        return PI * Math.pow(getRadius(), 2) * getHeight();
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
        return PI * Math.pow(radius, 2);
    }

    @Override
    public int compareTo(GeneralShape o) {
        return getHeight() > o.getHeight() ? 1 : -1;
    }
}
