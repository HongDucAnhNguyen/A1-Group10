package sait.sos.utility;

import java.util.Comparator;
import sait.sos.problemdomain.Shape;

/**
 * Compares two three-dimensional geometric shapes by volume.
 */
public class CompareVolume implements Comparator<Shape> {

	/**
	 * @param s1 - First shape to be compared.
	 * @param s2 - Second shape to be compared.
	 * @return a negative integer if s1 volume less than s2 volume,
	 * or zero if s1 volume equal to s2 volume,
	 * or a positive integer if s1 volume greater than s2 volume.
	 */
    @Override
    public int compare(Shape s1, Shape s2) {
    	if (s1.calcVolume() > s2.calcVolume()) {
            return 1;
    	}
        if (s1.calcVolume() < s2.calcVolume()) {
            return -1;
        }
        else {
        	return 0;
        }
    }
}