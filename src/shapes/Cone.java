package shapes;

public class Cone extends GeneralShape{
private double radius;
    public Cone(double height, double radius) {
        super(height);
        this.radius = radius;
    }
    public double calcVolume() {
        return (1/3) * PI * Math.pow(getRadius(), 2) * getHeight();
    }

    @Override
    public double calcBaseArea() {
        return PI * Math.pow(radius, 2);
    }

    @Override
    public int compareTo(GeneralShape o) {
        return getHeight() > o.getHeight() ? 1 : -1;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
