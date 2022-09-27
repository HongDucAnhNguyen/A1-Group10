package sait.sos.manager;

import sait.sos.problemdomain.*;
import sait.sos.utility.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Testing application.
 */
public class SortManager {
	private final Shape[] SHAPES;
	private String fileName;
	private String compareType;
	private String sortType;
	private Scanner keyboard;
	
	/**
	 * Controls the flow of the application.
	 * @throws FileNotFoundException
	 */
    public SortManager() throws FileNotFoundException {  	
    	displayMenu();
    	SHAPES = loadShapes();
    	optionHandler();
    	displayResults();
    }
    
    /**
     * Displays menu options and accepts user input.
     */
    private void displayMenu() {  		
    	String userCommand = "";    	
		keyboard = new Scanner(System.in);
		    
		while (!userCommand.equals("-quit")) {		        
		    System.out.println("Welcome to SORTING OUT SORTING!\n");		        
		    System.out.println("Please specify a filename, compare type, and sort type using this format:");
		    System.out.println("-f<filename> -t<compare type> -s<sort type>\n");		     
		    System.out.println("Compare Types: H for height; V for volume; A for base area.\n");
		    System.out.println("Sort Types: B for bubble; S for selection; I for insertion; "
		    		+ "M for merge; Q for quick; Z for radix.\n");		      
		    System.out.println("Enter -quit to exit the program.\n");
		    
		    System.out.print("ENTER COMMAND: ");
		    userCommand = keyboard.nextLine().toLowerCase();
		    String[] commandArray = userCommand.split(" ");
		    
		    for (String str : commandArray) {
		    	if (str.contains(".txt") && str.contains("-f")) {
		    		fileName = str.substring(2);
		            fileName = fileName.replaceAll("\"|\"" , "");
		            fileName = fileName.replaceFirst(".*(?=poly)", "");
		        }
		    	else if (str.contains("-t")) {
		    		compareType = str;
		        }
		    	else if (str.contains("-s")) {
		    		sortType = str;
		        }
		    	else {
		    		return;
		        }	    
		    }
		}
    }

    public Shape[] loadShapes() throws FileNotFoundException {        
        String shapeType;
        double height;
        double otherVal;
        int arrayIndex = 0;
        
        Scanner inFile = new Scanner(new File("res\\" + fileName));
        inFile.useDelimiter(" ");
        
        int shapeSize = inFile.nextInt();
        Shape[] shapes = new Shape[shapeSize];        
        System.out.println("This file has " + shapeSize + " shapes.");      
        
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
        return shapes;
    }

    private void optionHandler() {
    	if (sortType.substring(2).equals("b")) {
            Utility.bubbleSort(SHAPES, compareType.substring(2));
        }
    	else if (sortType.substring(2).equals("q")) {
            Utility.quicksort(SHAPES, 0, SHAPES.length - 1,  compareType.substring(2));
        }

    	else if (sortType.substring(2).equals("s")) {
            Utility.selectionSort(SHAPES,  compareType.substring(2));
        }

    	else if (sortType.substring(2).equals("i")) {
            Utility.insertionSort(SHAPES,  compareType.substring(2));
        }

    	else if (sortType.substring(2).equals("m")) {
            Utility.mergeSort(SHAPES,  compareType.substring(2));
        }
    	else {
    		System.out.println("Invalid sort type.");
    		return;
    	}
    }
    
    private void displayResults() {    	
        System.out.println("\nSORT RESULTS: ");
        for (Shape shape : SHAPES) {
            System.out.println(shape.getHeight() + "\t" + shape.calcBaseArea()
                    + "\t" + shape.calcVolume());
        }
        System.out.println();
    }          
}