package shapes.prisms;

import shapes.GeneralShape;

public abstract class GeneralPrism extends GeneralShape {
    private double side;

    public double getSide() {
        return side;
    }

    public GeneralPrism(double height, double side) {
        this.height = height;
        this.side = side;
    }

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