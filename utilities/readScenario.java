package utilities;

import java.io.*;
import java.util.Scanner;

public class readScenario {
    public void read() {

        int linecount = 0;

        try {
            // the file to be opened for reading
            FileInputStream fis = new FileInputStream("demo.txt");
            Scanner sc = new Scanner(fis); // file to be scanned
            // returns true if there is another line to read
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine()); // returns the line that was skipped
                this.linecount++;
            }
            sc.close(); // closes the scanner
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}