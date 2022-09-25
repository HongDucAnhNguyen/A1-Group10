package sait.sos.problemdomain;

public class PentagonalPrism extends GeneralPrism {
    public PentagonalPrism(double height, double side) {
        super(height, side);
    }

    public double calcVolume() {
        return calcBaseArea() * getHeight();
    }

    @Override
    public double calcBaseArea() {
        return (5 * Math.pow(getSide(), 2) * Math.tan(54))/4;
    }
}