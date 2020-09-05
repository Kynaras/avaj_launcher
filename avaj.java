
// import utilities.readScenario;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import globals.weatherProvider;
import utilities.validateScenario;

/**
 * main
 */
public class avaj {

    public void readScenario (String scenario) {
        try {
            // the file to be opened for reading
            FileInputStream fis = new FileInputStream(scenario);
            Scanner sc = new Scanner(fis); 
            // Do first line which has number of rounds to perform
            
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine()); 
                linecount++;
            }
            sc.close(); // closes the scanner
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    }
    public static void main(String[] args) {
        // readScenario reader = new readScenario();
        validateScenario validator = new validateScenario();
        if (validator.validateFormat("demo.txt")) {
            simulate
        } else {
            System.out.println("Error!");
        };
        // reader.read();


    }
}