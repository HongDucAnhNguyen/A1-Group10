package shapes.prisms;

public class OctagonalPrism extends GeneralPrism {
    public OctagonalPrism(double height, double side) {
        super(height, side);
    }

    public double calcVolume() {
        return calcBaseArea() * getHeight();
    }

    @Override
    public double calcBaseArea() {
        return 2 * (1 + Math.sqrt(2)) * Math.pow(getSide(), 2);
    }
}
