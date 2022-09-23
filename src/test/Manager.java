package test;

import shapes.Cone;
import shapes.Cylinder;
import shapes.GeneralShape;
import shapes.Pyramid;
import shapes.prisms.OctagonalPrism;
import shapes.prisms.PentagonalPrism;
import shapes.prisms.SquarePrism;
import shapes.prisms.TriangularPrism;
import utils.Sorter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Manager {

    public void manage() throws FileNotFoundException {

        ArrayList<GeneralShape> shapeList = new ArrayList<>();
        Scanner scan = new Scanner(new File("res/polyfor1.txt"));

        scan.useDelimiter(" ");
        int shapeSize = scan.nextInt();
        String shapeType;
        double height;
        double otherVal;
        GeneralShape[] shapes = new GeneralShape[shapeSize];
        System.out.println("this file has " + shapeSize + " shapes");
        int arrayIndex = 0;
        while (scan.hasNext() && arrayIndex < shapeSize) {
            shapeType = scan.next();
            height = scan.nextDouble();
            otherVal = scan.nextDouble();
            switch (shapeType.toLowerCase()) {
                case "cylinder":
                    shapes[arrayIndex] = new Cylinder(height, otherVal);
                    break;
                case "cone":
                    shapes[arrayIndex] = new Cone(height, otherVal);
                    break;

                case "pyramid":
                    shapes[arrayIndex] = new Pyramid(height, otherVal);
                    break;

                case "triangularprism":
                    shapes[arrayIndex] = new TriangularPrism(height, otherVal);
                    break;

                case "squareprism":
                    shapes[arrayIndex] = new SquarePrism(height, otherVal);
                    break;

                case "pentagonalprism":
                    shapes[arrayIndex] = new PentagonalPrism(height, otherVal);
                    break;

                case "octagonalprism":
                    shapes[arrayIndex] = new OctagonalPrism(height, otherVal);
                    break;
                default:
                    break;
            }

            shapeList.add(shapes[arrayIndex]);
            arrayIndex++;
        }
        MenuManager(shapes);
    }


    private void MenuManager(GeneralShape[] shapes) {
        Scanner inputScan = new Scanner(System.in);
        String command = "";
        while (!command.equals("-q")) {
            System.out.println("Welcome to sorter app, please follow instructions");
            System.out.println("-f<filename>");
            System.out.println("-t<specify type>");
            System.out.println("-s<specify sorting algorithm>");
            System.out.println();
            System.out.println("Types:");
            System.out.println("h for height; v for volume; a for base area ");
            System.out.println();
            System.out.println("Sorting types:");
            System.out.println(" b for Bubble; s for Selection, i is Insertion, " +
                    "m for Merge, q for Quick, z for sort of choice");
            System.out.println();
            System.out.print("ENTER COMMAND: ");
            command = inputScan.nextLine().toLowerCase();
            if (command.equals("-hs")) {
                new Sorter().BubbleSort(shapes);

            }
            System.out.println();
        }
    }
}
