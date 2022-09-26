package sait.sos.problemdomain;

/**
 * Abstract class to represent a prism.
 */
public abstract class Prism extends Shape {
    
	private double side;
    
    /**
     * Prism constructor.
     * @param height - Prism height
     * @param side - Prism side length.
     */
    public Prism(double height, double side) {
        super(height);
        this.side = side;
    }
    
    /**
	 * @return the side length.
	 */
    public double getSide() {
        return side;
    }
}