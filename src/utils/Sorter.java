package utils;

import shapes.GeneralShape;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorter {
    public  void quickSort() {

    }

    public void BubbleSort(GeneralShape[] shapes){
        List<GeneralShape> shapeList = new ArrayList<>();
        System.out.println("general demo sort initiated");
        //only for testing, this is not meant to be used in assignment
        for (GeneralShape shape: shapes
        ) {
            shapeList.add(shape);
        }
        Collections.sort(shapeList, Collections.reverseOrder());
        System.out.println("\nSort result: ");
        for (GeneralShape shape: shapeList
        ) {
            System.out.println(shape.getHeight());
        }

    }

    public  void SelectionSort() {

    }

    public  void InsertionSort() {

    }

    public  void mergeSort() {
    }

    public  void SixthSort() {

    }
}
