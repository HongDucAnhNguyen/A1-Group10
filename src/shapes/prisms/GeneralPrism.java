package shapes.prisms;

import shapes.GeneralShape;

public abstract class GeneralPrism extends GeneralShape {
    private double side;

    public double getSide() {
        return side;
    }

    public GeneralPrism(double height, double side) {
        super(height);
        this.side = side;
    }

    @Override
    public int compareTo(GeneralShape o) {
        return getHeight() > o.getHeight() ? 1 : -1;
    }
}
