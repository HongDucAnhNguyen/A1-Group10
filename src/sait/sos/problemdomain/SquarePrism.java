package sait.sos.problemdomain;

/**
 * Represents a square prism.
 */
public class SquarePrism extends Prism {
    
	/**
	 * Square prism constructor.
	 * @param height - Square prism height.
	 * @param side - Square prism length.
	 */
	public SquarePrism(double height, double side) {
        super(height, side);
    }

    /**
     * Calculates square base area.
     * @return the calculated base area.
     */
    @Override
	public double calcBaseArea() {
        return Math.pow(getSide(), 2);
    }
    
    /**
	 * Calculates square prism volume.
	 * @return the calculated volume.
	 */
    @Override
    public double calcVolume() {
        return calcBaseArea() * getHeight();
    }
}