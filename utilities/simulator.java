package utilities;

import java.io.*;
import java.util.Scanner;

import aircrafts.AircraftFactory;
import tower.WeatherTower;

public class Simulator {
    String file;
    int scenarioLoops;
    AircraftFactory factory = new AircraftFactory();
    WeatherTower tower = new WeatherTower();

    

    public Simulator (String file) {
        this.file = file;
    }

    private String[] getRegDetails(String line) {
            String trimmedLine = line.trim();
            String[] words;
            words = trimmedLine.split("\\s+");
            return words;
        }

    public void setUp() {

        //We need to first setup the tower + weather tower before we can register new vehicles. 

        int linecount = 0;
        String[] vehicleRegDetails;
        Flyable vehicle;
        
        try (FileInputStream fis = new FileInputStream(file);
        Scanner sc = new Scanner(fis);){
            while (sc.hasNextLine()) {
                if (linecount == 0) {
                    this.scenarioLoops = Integer.parseInt(sc.nextLine());
                } else {
                    vehicleRegDetails = getRegDetails(sc.nextLine());
                    vehicle = this.factory.newAircraft(vehicleRegDetails[0], vehicleRegDetails[1], Integer.parseInt(vehicleRegDetails[2]), Integer.parseInt(vehicleRegDetails[3]), Integer.parseInt(vehicleRegDetails[4]));
                    tower.register(vehicle);
                }
                linecount++; 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    }
