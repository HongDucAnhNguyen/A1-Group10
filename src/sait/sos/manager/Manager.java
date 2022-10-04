package sait.sos.manager;

import sait.sos.problemdomain.*;
import sait.sos.utility.*;
import java.io.*;
import java.util.*;

/**
 * Testing application.
 */
public class Manager {
	private Shape[] shapesArray;
	private String fileName;
	private String compareType;
	private String sortType;
	
    /**
     * Controls the flow of the program.
     */
	public Manager() {
    	displayMenu();
    	processInput();
    	handleOptions();
    	showResults();
    }
    
    /**
     * Displays menu options.
     */
    private void displayMenu() {    	
    	System.out.println("Welcome to SORTING OUT SORTING!\n");		        
	    System.out.println("Please specify a filename, compare type, and sort type using this format:");
	    System.out.println("-f<filename> -t<compare type> -s<sort type>\n");		     
	    System.out.println("Compare Types: H for height; V for volume; A for base area.");
	    System.out.println("Sort Types: B for bubble; S for selection; I for insertion; "
	    		+ "M for merge; Q for quick; Z for bogo.\n");
	    System.out.println("To close the program: -quit\n");
    }
    
    /**
     * Processes user input.
     */
    private void processInput() {
    	Scanner keyboard = new Scanner(System.in);
    	String userCommand = "";
    	boolean flag = false;
    	
    	while (!flag) {	        
		    System.out.print("ENTER COMMAND: ");		    
		    userCommand = keyboard.nextLine().toLowerCase();
	    	
		    if (userCommand.equals("-quit")) {
	    		System.out.println("\nGoodbye!");
	        	System.exit(0);
	    	}
	    			
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
		    }
		    
		    try {
		    	loadShapes();
		    	flag = true;
		    }
		    catch (FileNotFoundException e) {
		    	System.out.println("\nFile not found.\n");
		    }	    
		}
    	keyboard.close();
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
        
        Scanner inFile = new Scanner(new File("res\\" + fileName));
        inFile.useDelimiter(" ");
        
        int shapeSize = inFile.nextInt();
        shapesArray = new Shape[shapeSize];        
        System.out.println("This file has " + shapeSize + " shapes.");      
        
        while (inFile.hasNext() && arrayIndex < shapeSize) {
            shapeType = inFile.next();
            height = inFile.nextDouble();
            otherVal = inFile.nextDouble();
            switch (shapeType.toLowerCase()) {
                case "cylinder":
                    shapesArray[arrayIndex] = new Cylinder(height, otherVal);
                    break;
                case "cone":
                    shapesArray[arrayIndex] = new Cone(height, otherVal);
                    break;

                case "pyramid":
                    shapesArray[arrayIndex] = new Pyramid(height, otherVal);
                    break;

                case "triangularprism":
                    shapesArray[arrayIndex] = new TriangularPrism(height, otherVal);
                    break;

                case "squareprism":
                    shapesArray[arrayIndex] = new SquarePrism(height, otherVal);
                    break;

                case "pentagonalprism":
                    shapesArray[arrayIndex] = new PentagonalPrism(height, otherVal);
                    break;

                case "octagonalprism":
                    shapesArray[arrayIndex] = new OctagonalPrism(height, otherVal);
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
    	if (sortType.substring(2).equals("b")) {
            Utility.bubbleSort(shapesArray, compareType.substring(2));
        }
    	else if (sortType.substring(2).equals("q")) {
            Utility.quicksort(shapesArray, 0, shapesArray.length - 1,  compareType.substring(2));
        }

    	else if (sortType.substring(2).equals("s")) {
            Utility.selectionSort(shapesArray,  compareType.substring(2));
        }

    	else if (sortType.substring(2).equals("i")) {
            Utility.insertionSort(shapesArray,  compareType.substring(2));
        }

    	else if (sortType.substring(2).equals("m")) {
            Utility.mergeSort(shapesArray,  compareType.substring(2));
        }
    	else if (sortType.substring(2).equals("z")) {
    		Utility.bogoSort(shapesArray, compareType.substring(2));
    	}
    	else {
    		System.out.println("\nInvalid sort type.\n");
    		return;
    	}
    }
    
    /**
     * Displays the sorting results.
     */
    private void showResults() {  	
        System.out.println("\nSORT RESULTS: ");
        for (Shape shape : shapesArray) {
            System.out.println(shape.getHeight() + "\t" + shape.calcBaseArea()
                    + "\t" + shape.calcVolume());
        }
        System.out.println("Goodbye!");
    }
}