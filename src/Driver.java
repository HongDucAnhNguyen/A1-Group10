import shapes.Shape;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) throws FileNotFoundException {

        //Load the file and check that it exists
        File file = new File("../res/polyfor1.txt");
        //File file = new File("../res/polyfor3.txt");
        //File file = new File("../res/polyfor5.txt");

        if (!file.exists()) {
            System.out.println("Specified file does not exist.");
            System.exit(0);
        }

        //Create a scanner for the file and set the delimiter to be a white space character
        Scanner scanner = new Scanner(file);
        scanner.useDelimiter(" ");

        //Get the size of the array
        int arraySize = scanner.nextInt();

        //Create the array with the specified size
        Shape[] shapes = new Shape[arraySize];

        //Loop through the file
        while (scanner.hasNext()) {



        }

    }

}
