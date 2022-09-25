package sait.sos.problemdomain;

public class Pyramid extends GeneralShape{
    private double side;

    public double calcVolume() {
        return (1/3) * Math.pow(getSide(), 2) * getHeight();
    }

    @Override
    public double calcBaseArea() {
        return Math.pow(side, 2);
    }


    public Pyramid(double height, double side) {
        this.height = height;
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

}