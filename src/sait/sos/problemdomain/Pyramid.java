package sait.sos.problemdomain;

/**
 * Represents a pyramid.
 */
public class Pyramid extends Shape {    
	private double side;

    /**
	 * Pyramid constructor.
	 * @param height - Pyramid height.
	 * @param side - Pyramid side length.
	 */
    public Pyramid(double height, double side) {
        super(height);
        this.side = side;
    }

    /**
     * @return the pyramid side length.
     */
    public double getSide() {
        return side;
    }

    /**
     * @param side - Pyramid side length.
     */
    public void setSide(double side) {
        this.side = side;
    }

    /**
     * Calculates pyramid base area.
     * @return the calculated base area.
     */
    @Override
    public double calcBaseArea() {
        return Math.pow(side, 2);
    }
    
    /**
     * Calculates pyramid volume.
     * @return the calculated volume.
     */
	@Override
    public double calcVolume() {
        return (1/3) * calcBaseArea() * getHeight();
    }
}