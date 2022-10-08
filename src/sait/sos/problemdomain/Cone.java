package sait.sos.problemdomain;

/**
 * Represents a cone.
 */
public class Cone extends Shape {
	private double radius;
	
    /**
	 * Cone constructor.
	 * @param height - Cone height.
	 * @param radius - Cone radius.
	 */
    public Cone(double height, double radius) {
        super(height);
        this.radius = radius;
    }

    /**
     * @return the cone radius.
     */
    public double getRadius() {
        return radius;
    }

    /**
     * @param radius - Cone radius.
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    /**
     * Calculates cone base area.
     * @return the calculated base area.
     */
    @Override
    public double calcBaseArea() {
        return Math.PI * Math.pow(radius, 2);
    }
    
    /**
     * Calculates cone volume.
     * @return the calculated volume.
     */
    @Override
    public double calcVolume() {
        return (1.0 / 3) * calcBaseArea() * getHeight();
    }
}