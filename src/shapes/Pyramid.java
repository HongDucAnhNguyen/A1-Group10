package shapes;

public class Pyramid extends GeneralShape{
    private double side;

    public double calcVolume() {
        return (1/3) * Math.pow(getSide(), 2) * getHeight();
    }

    @Override
    public double calcBaseArea() {
        return Math.pow(side, 2);
    }

    @Override
    public int compareTo(GeneralShape o) {
        return getHeight() > o.getHeight() ? 1 : -1;
    }
    public Pyramid(double height, double side) {
        super(height);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

}
