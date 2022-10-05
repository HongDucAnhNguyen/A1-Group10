package sait.sos.manager;

import sait.sos.problemdomain.*;
import sait.sos.utility.*;
import java.io.*;
import java.util.*;

/**
 * Testing application.
 */
public class Manager {
	private Shape[] shapes;
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
	    			
	    	String[] commands = userCommand.split(" ");
	    
		    for (String str : commands) {
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
    	if (sortType.substring(2).equals("b")) {
            Utility.bubbleSort(shapes, compareType.substring(2));
        }
    	else if (sortType.substring(2).equals("q")) {
            Utility.quicksort(shapes, 0, shapes.length - 1,  compareType.substring(2));
        }

    	else if (sortType.substring(2).equals("s")) {
            Utility.selectionSort(shapes,  compareType.substring(2));
        }

    	else if (sortType.substring(2).equals("i")) {
    		Utility.insertionSort(shapes,  compareType.substring(2));
        }

    	else if (sortType.substring(2).equals("m")) {
            Utility.mergeSort(shapes,  compareType.substring(2));
        }
    	else if (sortType.substring(2).equals("z")) {
    		Utility.bogoSort(shapes, compareType.substring(2));
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
        for (Shape shape : shapes) {
            System.out.println("Height: " + shape.getHeight() + "\t" + "Base Area: " + shape.calcBaseArea()
                    + "\t" + "Volume: " + shape.calcVolume());
        }
        System.out.println("\nGoodbye!");
    }
}