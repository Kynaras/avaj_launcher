package utilities;

import java.io.File;
import java.io.PrintWriter;

public class SimulationWriter {
    public static File file;
    public static PrintWriter writer;
    
    private SimulationWriter(){
    }
    
    public static void setup(){
        file = new File(System.getProperty("user.dir") + "/Simulation.txt");
        try {
            file.createNewFile();
            writer = new PrintWriter(file);
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }

    public static void add(String string) {
        writer.println(string);
    }

    public static void flush(){
        writer.close();
    }
}
