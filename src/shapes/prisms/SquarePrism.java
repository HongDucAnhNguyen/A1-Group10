package shapes.prisms;

public class SquarePrism extends GeneralPrism {
    public SquarePrism(double height, double side) {
        super(height, side);
    }


    public double calcVolume() {
        return calcBaseArea() * getHeight();
    }

    @Override
    public double calcBaseArea() {
        return Math.pow(getSide(),2);
    }
}