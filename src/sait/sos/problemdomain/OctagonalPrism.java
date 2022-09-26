package sait.sos.problemdomain;

/**
 * Represents an octagonal prism.
 */
public class OctagonalPrism extends Prism {
	
	/**
	 * Octagonal prism constructor.
	 * @param height - Pentagonal prism height.
	 * @param side - Pentagonal prism length.
	 */
	public OctagonalPrism(double height, double side) {
        super(height, side);
    }
	
    /**
     * Calculates octagonal base area.
     * @return the calculated base area.
     */
    @Override
    public double calcBaseArea() {
        return 2 * (1 + Math.sqrt(2)) * Math.pow(getSide(), 2);
    }
    
    /**
     * Calculates octagonal base area.
     * @return the calculated volume.
     */
    @Override
    public double calcVolume() {
        return calcBaseArea() * getHeight();
    }
}