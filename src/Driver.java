import test.Manager;

import java.io.FileNotFoundException;

public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Driver running");
        Manager mana = new Manager();
        mana.readFile();
    }
}
