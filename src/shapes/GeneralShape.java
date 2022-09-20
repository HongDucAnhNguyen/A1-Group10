package shapes;

public abstract class GeneralShape implements Comparable<GeneralShape>{

    //declare height variable
     private static double height;

    //default constructor
    public GeneralShape(){}

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

    public abstract double calcVolume();
     public abstract double calcBaseArea();

}
