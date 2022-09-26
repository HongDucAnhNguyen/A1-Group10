package sait.sos.problemdomain;

/**
 * Abstract class to represent a prism.
 */
public abstract class Prism extends Shape {
    
	private double side;

	/**
	 * @return the side length.
	 */
    public double getSide() {
        return side;
    }
    
    /**
     * @param height - Prism height
     * @param side - Prism side length.
     */
    public Prism(double height, double side) {
        super(height);
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