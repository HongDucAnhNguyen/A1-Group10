package test;

import shapes.Cone;
import shapes.Cylinder;
import shapes.GeneralShape;
import shapes.Pyramid;
import shapes.prisms.*;
import utils.Sorter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Manager {

    public void manage() throws FileNotFoundException {

try{
    String chosenFile = "";
    String chosenType = "";
    String chosenSort = "";
    Scanner inputScan = new Scanner(System.in);
    String command = "";
    while (!command.equals("-quit")) {
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
        System.out.println(command);
        String[] commandArr = command.split(" ");


        for (String str : commandArr) {
            if (str.contains(".txt") && str.contains("-f")) {
                chosenFile = str.substring(2);
                chosenFile = chosenFile.replaceAll("\"|\"" , "");
                chosenFile = chosenFile.replaceAll("(res\\\\)" , "");
                chosenFile = chosenFile.replaceAll("(c:\\\\temp\\\\)" , "");


            }
            else if (str.contains("-t")) {
                chosenType = str;
            } else if (str.contains("-s")) {
                chosenSort = str;
            } else {
                return;
            }
        }
        System.out.println(chosenFile);
            GeneralShape[] shapes = fileHandler(chosenFile);
            MenuManager(shapes, chosenType, chosenSort);
    }
}
catch(NumberFormatException e){
    System.out.println("invalid command");
}

    }
    public GeneralShape[] fileHandler(String chosenFile) throws FileNotFoundException{
        Scanner scan = new Scanner(new File("res\\" + chosenFile));

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


            arrayIndex++;
        }
        return shapes;
    }


    private void MenuManager(GeneralShape[] shapes, String chosenType, String chosenSort) {

            if (chosenSort.substring(2).equals("b")) {
                new Sorter().BubbleSort(shapes, chosenType.substring(2));
            }
            if (chosenSort.substring(2).equals("q")) {

                new Sorter().quickSort(shapes, 0, shapes.length - 1,  chosenType.substring(2));

            }


            if (chosenSort.substring(2).equals("s")) {

                new Sorter().SelectionSort(shapes,  chosenType.substring(2));

            }


            if (chosenSort.substring(2).equals("i")) {
                new Sorter().InsertionSort(shapes,  chosenType.substring(2));

            }


            if (chosenSort.substring(2).equals("m")) {
                new Sorter().mergeSort(shapes,  chosenType.substring(2));

            }


            System.out.println("\nSort results: ");
            for (GeneralShape shape : shapes
            ) {
                System.out.println(shape.getHeight() + "\t" + shape.calcBaseArea()
                        + "\t" + shape.calcVolume());
            }
            System.out.println();
        }
    }

