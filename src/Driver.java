import shapes.Cone;
import shapes.Cylinder;
import shapes.Pyramid;
import shapes.Shape;
import shapes.prisms.OctagonalPrism;
import shapes.prisms.PentagonalPrism;
import shapes.prisms.SquarePrism;
import shapes.prisms.TriangularPrism;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) throws FileNotFoundException {

        //Load the file and check that it exists
        File file = new File("./res/polyfor1.txt");
        //File file = new File("./res/polyfor3.txt");
        //File file = new File("./res/polyfor5.txt");
        //File file = new File("./res/polyNameBIG.txt");

        if (!file.exists()) {
            System.out.println("Specified file does not exist.");
            System.exit(0);
        }

        //Create a scanner for the file and set the delimiter to be a white space character
        Scanner scanner = new Scanner(file);
        scanner.useDelimiter(" ");

        //Get the size of the array from the first value in the text file
        int arraySize = scanner.nextInt();

        System.out.println("There are " + arraySize + " shapes to load.");

        //Create an array with the specified size
        Shape[] shapes = new Shape[arraySize];

        int i = 0;

        long startTime = System.currentTimeMillis();

        //Loop through the file
        while (scanner.hasNext()) {

            //Get the type of shape
            String shapeType = scanner.next();

            //Get the shape attributes
            double height = scanner.nextDouble();
            double otherValue = scanner.nextDouble();

            //Create the shape object
            switch (shapeType.toLowerCase()) {

                case "cylinder":
                    shapes[i] = new Cylinder();
                    break;

                case "cone":
                    shapes[i] = new Cone();
                    break;

                case "pyramid":
                    shapes[i] = new Pyramid();
                    break;

                case "triangularprism":
                    shapes[i] = new TriangularPrism();
                    break;

                case "squareprism":
                    shapes[i] = new SquarePrism();
                    break;

                case "pentagonalprism":
                    shapes[i] = new PentagonalPrism();
                    break;

                case "octagonalprism":
                    shapes[i] = new OctagonalPrism();
                    break;

                default:
                    break;

            }

            i++;
        }

        System.out.println("Loaded " + shapes.length + " shapes.");
        System.out.println("Time taken: " + (System.currentTimeMillis() - startTime) + "ms");

    }

}
