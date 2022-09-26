package sait.sos.utility;

import java.util.Comparator;
import sait.sos.problemdomain.Shape;

/**
 * Compares two three-dimensional geometric shapes by base area.
 */
public class CompareBaseArea implements Comparator<Shape> {
	
	/**
	 * @param s1 - First shape to be compared.
	 * @param s2 - Second shape to be compared.
	 * @return a negative integer if s1 base area less than s2 base area,
	 * or zero if s1 base area equal to s2 base area,
	 * or a positive integer if s1 base area greater than s2 base area.
	 */
    @Override
    public int compare(Shape s1, Shape s2) {
    	if (s1.calcBaseArea() > s2.calcBaseArea()) {
            return 1;
    	}
        if (s1.calcBaseArea() < s2.calcBaseArea()) {
            return -1;
        }
        else {
        	return 0;
        }
    }
}