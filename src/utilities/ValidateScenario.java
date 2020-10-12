package utilities;

import java.io.*;
import java.util.Scanner;

import globals.Globals;

public class ValidateScenario {
    protected String errorMessage = "The scenario file submitted is not valid";
    protected int linecount = 0;

    private boolean isNumeric(String line) {
        if (line == null || line.length() == 0) {
            this.errorMessage = "The starting cordinates for the vehicles must include numeric digits only and cannot be excluded";
            return false;
        }
        if (line.chars().allMatch(Character::isDigit)) {
            return true;
        } else {
            this.errorMessage = "The cordinates for the vehicles must include numeric digits only";
            return false;
        }
    }

    private boolean countWords(String line) {    
        String trimmedLine = line.trim();
        String[] words;

        words = trimmedLine.split("\\s+");
        if (words.length != 5) {
            this.errorMessage = "Not all elements of the vehicle details are present. You need: A vehicle type, name and starting cordinates.";
            return false;
        }
        return true;
    }

    private boolean wordFormat(String line) {
        String trimmedLine = line.trim();
        String[] words;
        words = trimmedLine.split("\\s+");
        if (!Globals.VEHICLES.contains(words[0]) || !isNumeric(words[2]) || !isNumeric(words[3]) || !isNumeric(words[4]) ) {
            if (!Globals.VEHICLES.contains(words[0])) {
                this.errorMessage = "The vehicles must be of a recognised type. Ie: Baloon, JetPlane or Helicopter";
            }
            return false;
        }
        return true;
    }

    public boolean validateFormat(String file) {

        String line;

     try (FileInputStream fis = new FileInputStream(file);
        Scanner sc = new Scanner(fis);){
            this.linecount = 0;
            while (sc.hasNextLine()){
                this.linecount++;
                line = sc.nextLine();
                if (this.linecount == 1 && !isNumeric(line)) {
                    this.errorMessage = "The first line of the file must contain a single number, digits only!";
                    return false;
                }
                if (this.linecount > 1 && !countWords(line)) {
                    return false;
                } else if (this.linecount > 1 && !wordFormat(line)) {
                    return false;
                }
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public String getErrorMessage() {
        return errorMessage;
    }

    public int getLinecount() {
        return linecount;
    }
}
