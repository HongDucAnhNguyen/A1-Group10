package sait.sos.problemdomain;

/**
 * Represents a pentagonal prism.
 */
public class PentagonalPrism extends Prism {
    
	/**
	 * Pentagonal prism constructor.
	 * @param height - Pentagonal prism height.
	 * @param side - Pentagonal prism length.
	 */
	public PentagonalPrism(double height, double side) {
        super(height, side);
    }
	
    /**
     * Calculates pentagonal base area.
     * @return the calculated base area.
     */
    @Override
    public double calcBaseArea() {
    	return (5 * Math.pow(getSide(), 2) * Math.tan(Math.toRadians(54))) / 4;
    }
    
    /**
     * Calculates pentagonal base area.
     * @return the calculated volume.
     */
	@Override
    public double calcVolume() {
        return calcBaseArea() * getHeight();
    }
}