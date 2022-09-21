package shapes.prisms;

public class TriangularPrism extends GeneralPrism {

    public TriangularPrism(double height, double side) {
        super(height, side);
    }

    public double calcVolume() {
        return calcBaseArea() * getHeight();
    }

    @Override
    public double calcBaseArea() {
        return (Math.pow(getSide(), 2) * Math.sqrt(3))/4;
    }
}
