package sait.sos.manager;

import sait.sos.problemdomain.*;
import sait.sos.utility.*;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

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
        } catch (Exception ex) {
            System.out.println("Error loading shapes!");
            ex.printStackTrace();
            System.exit(0);
        }

    }
    
    /**
     * Reads text file and populates array of shapes.
     * @throws FileNotFoundException Thrown if the provided file does not exist
     */
    public void loadShapes() throws FileNotFoundException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String shapeType;
        double height;
        double otherVal;
        int arrayIndex = 0;

        //The ternary operator here does the following:
        //  1. Checks if the file already has "res" in it, adding it if it does
        //  2. Changes "/" or "\" to be a system independent file separator so that it will work on Windows & macOS
        Scanner inFile = new Scanner(new File(fileName.contains("res\\") ? fileName.replace("\\", File.separator) : fileName.contains("res/") ? fileName.replace("/", File.separator) : "res" + File.separator + fileName));
        inFile.useDelimiter(" ");
        
        int shapeSize = inFile.nextInt();
        shapes = new Shape[shapeSize];        
        System.out.println("\nThis file has " + shapeSize + " shapes.");      
        
        while (inFile.hasNext() && arrayIndex < shapeSize) {

            //Get the values from the file
            shapeType = inFile.next();
            height = inFile.nextDouble();
            otherVal = inFile.nextDouble();

            //Find the class
            Class cls = Class.forName("sait.sos.problemdomain." + shapeType);

            //Set the parameter types
            Class[] paramTypes = new Class[2];
            paramTypes[0] = Double.TYPE;
            paramTypes[1] = Double.TYPE;

            //Get the constructor
            Constructor ct = cls.getConstructor(paramTypes);

            //Set the parameters
            Object[] argList = new Object[2];
            argList[0] = height;
            argList[1] = otherVal;

            //Add the shape to the array
            shapes[arrayIndex] = (Shape) ct.newInstance(argList);

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