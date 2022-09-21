package shapes;

public abstract class GeneralShape implements Comparable<GeneralShape> {

    //declare height variable
    private static double height;
    protected static final double PI = 3.14;

    //default constructor
    public GeneralShape() {
    }

    //custom constructor
    public GeneralShape(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public double setHeight(double height) {
        return this.height = height;
    }
//abstract methods

    public abstract double calcBaseArea();
    public abstract double calcVolume();

}
