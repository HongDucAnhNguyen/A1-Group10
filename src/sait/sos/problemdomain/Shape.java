package sait.sos.problemdomain;

public abstract class Shape implements Comparable<Shape> {

    //declare height variable
    protected double height;


    protected final double PI = 3.14;

    //default constructor
    public Shape() {

    }

    //custom constructor


    public double getHeight() {
        return height;
    }


    public double setHeight(double height) {
        return this.height = height;
    }
//abstract methods

    public abstract double calcBaseArea();

    public abstract double calcVolume();

    @Override
    public int compareTo(Shape o) {
        if (this.getHeight() > o.getHeight()) {
            return 1;
        } else if (this.getHeight() < o.getHeight()) {
            return -1;
        } else {
            return 0;
        }


    }

}