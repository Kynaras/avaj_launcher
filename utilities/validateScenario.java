package utilities;

import java.io.*;
import java.util.Scanner;

public class validateScenario {

    private boolean isNumeric(String line) {
        if (line == null || line.length() == 0) {
            return false;
        }
        return line.chars().allMatch(Character::isDigit);
    }

    private boolean countWords(String line) {
        String trimmedLine = line.trim();
        String words[];
        // if (trimmedLine.isEmpty())
        //     return false;
        words = trimmedLine.split("\\s+");
        if (words.length != 5) {
            return false;
        }
        if (words[0].equals("helicopter")) {
            return false;
        }
    }

    private boolean wordFormat(String line) {


    }

    public boolean validateFormat() {

        int linecount = 0;
        String line;

        try {

            FileInputStream fis = new FileInputStream("demo.txt");
            Scanner sc = new Scanner(fis);

            while (sc.hasNextLine()) {
                linecount++;
                line = sc.nextLine();
                if (linecount == 1 && !isNumeric(line)) {
                    sc.close();
                    return false;
                }
                if (linecount > 1 && !countWords(line)) {
                    sc.close();
                    return false;
                } else if (linecount > 1 && !wordFormat(line)) {
                    sc.close();
                    return false;
                }

            }
            sc.close(); // closes the scanner
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
