package utils;

import shapes.GeneralShape;

import java.util.ArrayList;
import java.util.Arrays;


public class Sorter {
    public void quickSort() {

    }

    public static void BubbleSort(GeneralShape[] shapes) {
        for(int i = 0; i < shapes.length - 1; i++) {
            for(int j = 0; j < shapes.length - i - 1; j++) {
                if(shapes[j].compareTo(shapes[j+1]) < 0) {
                    GeneralShape temp = shapes[j];
                    shapes[j] = shapes[j+1];
                    shapes[j+1] = temp;
                }
            }
          }

        System.out.println("\nSort result: ");
        for (GeneralShape shape : shapes
        ) {
            System.out.println(shape.getHeight());
        }

    }

    public void SelectionSort() {

    }

    public void InsertionSort() {

    }

    public void mergeSort() {
    }

    public void SixthSort() {

    }
}
