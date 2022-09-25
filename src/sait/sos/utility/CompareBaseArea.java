package sait.sos.utility;

import java.util.Comparator;

import sait.sos.problemdomain.GeneralShape;

public class CompareBaseArea implements Comparator<GeneralShape> {

    @Override
    public int compare(GeneralShape o1, GeneralShape o2) {
        if (o1.calcBaseArea() < o2.calcBaseArea())
            return -1;
        if (o1.calcBaseArea() > o2.calcBaseArea())
            return 1;
        else return 0;
    }
}