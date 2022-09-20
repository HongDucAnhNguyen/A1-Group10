package shapes.prisms;

import shapes.GeneralShape;

public abstract class GeneralPrism extends GeneralShape {
    private double side;

    public GeneralPrism(double height, double side) {
        super(height);
        this.side = side;
    }

    @Override
    public double calcVolume() {
        return 0;
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
