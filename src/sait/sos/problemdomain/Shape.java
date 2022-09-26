package sait.sos.problemdomain;

import java.util.Comparator;

/**
 * Abstract class to represent a three-dimensional geometric shape.
 */
public abstract class Shape implements Comparable<Shape>, Comparator<Shape> {

    private double height;    

    /**
     * @param height - Shape height.
     */
    public Shape(double height) {
    	this.height = height;
    }
    
    /**
     * @return the height of this shape.
     */
	public double getHeight() {
		return height;
	}
	
	/**
	 * @param height - Shape height.
	 */
	public void setHeight(double height) {
		this.height = height;
	}
    
	/**
	 * @return the calculated base area.
	 */
    public abstract double calcBaseArea();

    /**
     * @return the calculated volume.
     */
    public abstract double calcVolume();

    /**
     * @param s - Shape to be compared.
     * @return a negative integer if this shape height less than s height,
     * or zero if this shape height equal to s height,
     * or a positive integer if this shape height greater than s height.
     */
    @Override
    public int compareTo(Shape s) {
        if (this.getHeight() > s.getHeight()) {
            return 1;
        } else if (this.getHeight() < s.getHeight()) {
            return -1;
        } else {
            return 0;
        }
    }
}