package sait.sos.problemdomain;

/**
 * Represents a triangular prism.
 */
public class TriangularPrism extends Prism {
	
	/**
	 * Triangular prism constructor.
	 * @param height - Triangular prism height.
	 * @param side - Triangular prism length.
	 */
    public TriangularPrism(double height, double side) {
        super(height, side);
    }

    /**
     * Calculates triangular base area.
     * @return the calculated base area.
     */
    @Override
    public double calcBaseArea() {
        return (Math.pow(getSide(), 2) * Math.sqrt(3)) / 4;
    }
    
    /**
     * Calculates triangular prism volume.
     * @return the calculated volume.
     */
    @Override
    public double calcVolume() {
        return calcBaseArea() * getHeight();
    }
}