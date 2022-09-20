package shapes;

public class Pyramid extends GeneralShape{
    private double side;

    @Override
    public double calcVolume() {
        return 0;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public Pyramid(double height, double side) {
        super(height);
        this.side = side;
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
