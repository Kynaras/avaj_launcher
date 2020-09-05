package utilities;

import java.io.*;
import java.util.Scanner;

import globals.globals;

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
        return true;
    }

    private boolean wordFormat(String line) {
        String trimmedLine = line.trim();
        String words[];
        words = trimmedLine.split("\\s+");
        if (!globals.VEHICLES.contains(words[0]) || !isNumeric(words[2]) || !isNumeric(words[3]) || !isNumeric(words[4]) ) {
            return false;
        }
        return true;
    }

    public boolean validateFormat(String file) {

        int linecount = 0;
        String line;

        try {

            FileInputStream fis = new FileInputStream(file);
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
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
