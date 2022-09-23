package shapes;

public abstract class GeneralShape implements Comparable<GeneralShape> {

    //declare height variable
    protected  double height;

    protected  final double PI = 3.14;

    //default constructor
    public GeneralShape() {
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
    public int compareTo(GeneralShape o) {
        if(this.getHeight() > o.getHeight()){
            return 1;
        } else if (this.getHeight() < o.getHeight()) {
            return -1;
        }
        else{
            return 0;
        }


    }

}
