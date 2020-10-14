
import tower.Simulator;
import utilities.SimulationWriter;
import utilities.ValidateScenario;


public class Avaj {

  
    public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println("Please provide a scenario file name for Avaj to read");
            return;
        }
        SimulationWriter.setup();
        ValidateScenario validator = new ValidateScenario();
        Simulator simulator = new Simulator(System.getProperty("user.dir") + "/" + args[0]);
        if (validator.validateFormat(System.getProperty("user.dir") + "/" + args[0])) {
            simulator.setUp();
            simulator.runSimulation();
            SimulationWriter.flush();
        } else {
            System.out.println("Error: " + validator.getErrorMessage());
            System.out.println("The error was located on line : " + validator.getLinecount());
        }
    }
}