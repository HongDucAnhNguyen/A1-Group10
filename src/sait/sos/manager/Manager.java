package sait.sos.manager;

import sait.sos.problemdomain.*;
import sait.sos.utility.*;
import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Testing application.
 */
public class Manager {
	private Shape[] shapes;
	private String fileName;
	private String compareType;
	private String sortType;
    private long sortStartTime;
	
    /**
     * Controls the flow of the program.
     */
	public Manager(String[] args) {

        //If no arguments were sent, display the options menu
        if (args == null || args.length < 1) {
            System.out.println("Command line arguments cannot be empty!");
            System.exit(0);
        }

    	processInput(args);
    	handleOptions();
    	showResults();
    }

    /**
     * Processes the application command line arguments
     * @param args Provided command line arguments
     */
    private void processInput(String[] args) {

        for (String arg : args) {

            if (arg.length() < 2) {
                System.out.println("Invalid argument: " + arg);
                System.exit(0);
            }

            switch (arg.substring(0, 2)) {

                case "-f":
                case "-F":
                    fileName = arg.substring(2);
                    break;

                case "-t":
                case "-T":
                    compareType = arg.substring(2);
                    break;

                case "-s":
                case "-S":
                    sortType = arg.substring(2);
                    break;

            }

        }

        try {
            loadShapes();
        } catch (FileNotFoundException e) {
            System.out.println("File " + fileName + " not found.");
            System.exit(0);
        }

    }
    
    /**
     * Reads text file and populates array of shapes.
     * @throws FileNotFoundException
     */
    public void loadShapes() throws FileNotFoundException {        
        String shapeType;
        double height;
        double otherVal;
        int arrayIndex = 0;

        Scanner inFile = new Scanner(new File(fileName.contains("res\\") ? "" : "res\\" + fileName));
        inFile.useDelimiter(" ");
        
        int shapeSize = inFile.nextInt();
        shapes = new Shape[shapeSize];        
        System.out.println("\nThis file has " + shapeSize + " shapes.");      
        
        while (inFile.hasNext() && arrayIndex < shapeSize) {
            shapeType = inFile.next();
            height = inFile.nextDouble();
            otherVal = inFile.nextDouble();
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
        inFile.close();
    }
    
    /**
     * Calls the appropriate sorting method based on chosen sort type.
     */
    private void handleOptions() {
    	if (sortType.equalsIgnoreCase("b")) {
            System.out.println("Using Bubble Sort.");
            sortStartTime = System.currentTimeMillis();
            Utility.bubbleSort(shapes, compareType);
        }
    	else if (sortType.equalsIgnoreCase("q")) {
            System.out.println("Using Quick Sort.");
            sortStartTime = System.currentTimeMillis();
            Utility.quicksort(shapes, 0, shapes.length - 1,  compareType);
        }

    	else if (sortType.equalsIgnoreCase("s")) {
            System.out.println("Using Selection Sort.");
            sortStartTime = System.currentTimeMillis();
            Utility.selectionSort(shapes, compareType);
        }

    	else if (sortType.equalsIgnoreCase("i")) {
            System.out.println("Using Insertion Sort.");
            sortStartTime = System.currentTimeMillis();
    		Utility.insertionSort(shapes, compareType);
        }

    	else if (sortType.equalsIgnoreCase("m")) {
            System.out.println("Using Merge Sort.");
            sortStartTime = System.currentTimeMillis();
            Utility.mergeSort(shapes, compareType);
        }
    	else if (sortType.equalsIgnoreCase("z")) {
            System.out.println("Using Bogo Sort.");
            sortStartTime = System.currentTimeMillis();
    		Utility.bogoSort(shapes, compareType);
    	}
    	else {
    		System.out.println("\nInvalid sort type.\n");
    		System.exit(0);
    	}
    }
    
    /**
     * Displays the sorting results.
     */
    private void showResults() {  	
        System.out.println("\nSORT RESULTS: ");
        for (Shape shape : shapes) {
            System.out.println("Height: " + shape.getHeight() + "\t" + "Base Area: " + shape.calcBaseArea()
                    + "\t" + "Volume: " + shape.calcVolume());
        }
        System.out.println("\nSort completed in " + (System.currentTimeMillis() - sortStartTime) + "ms.");
        System.out.println("\nGoodbye!");
    }
}