package sait.sos.problemdomain;

/**
 * Represents a cylinder.
 */
public class Cylinder extends Shape {
    
	private double radius;

    /**
	 * Cylinder constructor.
	 * @param height - Cylinder height.
	 * @param radius - Cylinder radius.
	 */
    public Cylinder(double height, double radius) {
        super(height);
        this.radius = radius;
    }

    /**
     * @return the cylinder radius.
     */
    public double getRadius() {
        return radius;
    }

    /**
     * @param radius - Cylinder radius.
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * Calculates cylinder base area.
     * @return the calculated base area.
     */
    @Override
    public double calcBaseArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    /**
     * Calculates cylinder volume.
     * @return the calculated volume.
     */
	@Override
    public double calcVolume() {
        return calcBaseArea() * getHeight();
    }
}