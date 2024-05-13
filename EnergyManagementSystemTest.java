package EnergyResourcesManagment;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.IOException;
public class EnergyManagementSystemTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to our Energy Resources Management System");

        // Ask for the name of the energy system
        System.out.println("Enter the name of the energy system: ");
        String name = scanner.nextLine();

        // Validate the name
        while (!name.matches("^[a-zA-Z].{0,19}$")) {
            System.out.println("Invalid input. The name must start with a character and can't be longer than 20 characters.");
            System.out.println("Enter the name of the energy system: ");
            name = scanner.nextLine();
        }

        // Ask for a unique ID of the energy system
        System.out.println("Enter a unique ID of the energy system: ");
        String idInput = scanner.nextLine();

        // Validate the ID
        while (!idInput.matches("^\\d{1,3}$")) {
            System.out.println("Invalid input. The ID must be no more than 3 numbers.");
            System.out.println("Enter a unique ID of the energy system: ");
            idInput = scanner.nextLine();
        }
        int id = Integer.parseInt(idInput);

        // Now you can create your EnergySystem
        EnergySystem energySystem = new EnergySystem(id);
        // Set the name of the energy system
        // energySystem.setName(name); // You need to implement this method in your EnergySystem class

        System.out.println("Energy system created with name: " + name + " and ID: " + id);

        String option = "";
        while (!option.equalsIgnoreCase("E")) {
            System.out.println("\nMenu:");
            System.out.println("A - Add Solar Panels");
            System.out.println("B - Add Wind Turbines");
            System.out.println("C - Add Hydroelectric Generators");
            System.out.println("D - Add Battery"); \\FE ERROR WHEN CREATING ARRAY OF BATTERIES
            System.out.println("E - Proceed");
            System.out.println("Enter your choice: ");
            option = scanner.nextLine().toUpperCase();

            switch (option) {
                case "A":
                    addSolarPanels(scanner, energySystem);
                    break;
                case "B":
                    addWindTurbines(scanner, energySystem);
                    break;
                case "C":
                    addHydroGenerators(scanner, energySystem);
                    break;
                case "D":
                    addBattery(scanner, energySystem);
                    break;
                  
                default:
                    System.out.println("Invalid option. Please enter A, B, C, D, or E.");
                    break;
                case "E":
                    System.out.println("Proceeding...");
                    System.out.println("Proceeding...");
                    String subOption = "";
                    while (!subOption.equalsIgnoreCase("E")) {
                        System.out.println("Menu:");
                        System.out.println("A - Edit Energy Resources");
                        System.out.println("B - Calculate Consumption");
                        System.out.println("C - Calculate Total Energy Production");
                        System.out.println("D - Compare Production to Demand"); \\NA2SA
                        System.out.println("E - Save All Info to Files and Exit");
                        System.out.println("Enter your choice: "); \\ GARBHA NTA
                        subOption = scanner.nextLine().toUpperCase();

                        switch (subOption) {
                            case "A":
                            	editEnergyResources(energySystem,scanner);
                                // ...
                                break;
                            case "B":
                            	calculateConsumption(scanner, energySystem);
                                break;
                            case "C":
                                // Calculate total energy production
                            	calculateTotalEnergyProduction(scanner, energySystem);

                                break;
                            case "D":
                            	compareProductionToDemand();
                                // ...
                                break;
                            case "E":
                                System.out.println("Saving all info to files...");
                                try {
                                    FileWriter writer = new FileWriter("C:\\Users\\thepy\\OneDrive\\Desktop\\saved_energy_resources.txt");
                                    // Write all info to the file
                                    // ...
                                    writer.close();
                                    System.out.println("All info saved successfully!");
                                } catch (IOException e) {
                                    System.out.println("An error occurred while saving the info.");
                                    e.printStackTrace();
                                }
                                break;
                            default:
                                System.out.println("Invalid option. Please enter A, B, C, D, or E.");
                                break;
                        }
                    }
                    break;
                case "F":
                    System.out.println("Exiting program...");
                    break;
               
        }
        scanner.close(); // Close the scanner when exiting the program
    }}
                  
                    
            
      

    private static void addSolarPanels(Scanner scanner, EnergySystem energySystem) {
        System.out.println("Enter the number of solar panels to add (max 50): ");
        int solarPanelCount = getValidInput(scanner, 50);

        // Prompt the user for solar panel data
        System.out.print("Enter the efficiency of the solar panels: ");
        double efficiency = getDoubleInput(scanner);
        System.out.print("Enter the orientation of the solar panels: ");
        double orientation = getDoubleInput(scanner);
        System.out.print("Enter the surface area of the solar panels: ");
        double surfaceArea = getDoubleInput(scanner);

        // Add the specified number of solar panels
        for (int i = 1; i <= solarPanelCount; i++) {
            String panelId = "Panel" + i;
            SolarPanel panel = new SolarPanel(panelId, efficiency, orientation, surfaceArea);
            energySystem.addEnergyResource(panel);
        }
    }

    private static void addWindTurbines(Scanner scanner, EnergySystem energySystem) {
        System.out.println("Enter the number of wind turbines to add (max 50): ");
        int windTurbineCount = getValidInput(scanner, 50);

        // Prompt the user for wind turbine data
        System.out.print("Enter the efficiency of the wind turbines: ");
        double efficiency = getDoubleInput(scanner);
        System.out.print("Enter the blade length of the wind turbines: ");
        double bladeLength = getDoubleInput(scanner);
        System.out.print("Enter the average wind speed for the wind turbines: ");
        double windSpeed = getDoubleInput(scanner);

        // Add the specified number of wind turbines
        for (int i = 1; i <= windTurbineCount; i++) {
            String turbineId = "Turbine" + i;
            WindTurbine turbine = new WindTurbine(turbineId, efficiency, bladeLength, windSpeed);
            energySystem.addEnergyResource(turbine);
        }
    }

    private static void addHydroGenerators(Scanner scanner, EnergySystem energySystem) {
        System.out.println("Enter the number of hydroelectric generators to add (max 50): ");
        int hydroGeneratorCount = getValidInput(scanner, 50);

        // Prompt the user for hydroelectric generator data
        System.out.print("Enter the efficiency of the hydroelectric generators: ");
        double efficiency = getDoubleInput(scanner);
        System.out.print("Enter the head of the hydroelectric generators: ");
        double head = getDoubleInput(scanner);

        // Add the specified number of hydroelectric generators
        for (int i = 1; i <= hydroGeneratorCount; i++) {
            String generatorId = "Generator" + i;
            HydroelectricGenerator generator = new HydroelectricGenerator(generatorId, efficiency, head);
            energySystem.addEnergyResource(generator);
        }
    }

    private static void addBattery(Scanner scanner, EnergySystem energySystem) {
        System.out.print("Enter the ID of the battery: ");
        String batteryId = scanner.nextLine();
        System.out.print("Enter the maximum capacity of the battery: ");
        double batteryMaxCapacity = getDoubleInput(scanner);
        // Create the battery and add it to the energy system
        Battery battery = new Battery(batteryId, batteryMaxCapacity);
        energySystem.addEnergyResource(battery);
    }
    private static void editEnergyResources(EnergySystem energySystem, Scanner scanner) {
        String subOption = "";
        while (!subOption.equalsIgnoreCase("D")) {
            System.out.println("Edit Energy Resources Menu:");
            System.out.println("A - Remove Solar Panels"); \\ NA2SA 
            System.out.println("B - Remove Wind Turbines"); \\ NA2SA
            System.out.println("C - Remove Hydroelectric Generators"); \\ NA2SA
            System.out.println("D - Back");
            System.out.println("Enter your choice: ");
            subOption = scanner.nextLine().toUpperCase();

            switch (subOption) {
                case "A":
                    removeSolarPanels(energySystem, scanner);
                    break;
                case "B":
                    removeWindTurbines(energySystem, scanner);
                    break;
                case "C":
                    removeHydroGenerators(energySystem, scanner);
                    break;
                case "D":
                    System.out.println("Going back...");
                    break;
                default:
                    System.out.println("Invalid option. Please enter A, B, C, or D.");
                    break;
            }
        }
    }

    // Method to remove solar panels
    private static void removeSolarPanels(EnergySystem energySystem, Scanner scanner) {
        System.out.println("Enter the ID of the solar panel to remove: ");
        String id = scanner.nextLine();

        // Iterate through the energy resources to find and remove the solar panel
        boolean removed = false;
        for (EnergyResource resource : energySystem.energyResources) {
            if (resource instanceof SolarPanel && resource.getId().equals(id)) {
                energySystem.removeEnergyResource(resource);
                removed = true;
                break; // Stop searching after finding and removing the solar panel
            }
        }

        if (removed) {
            System.out.println("Solar panel with ID " + id + " has been removed.");
        } else {
            System.out.println("Solar panel with ID " + id + " not found.");
        }
    }

    

    // Method to remove wind turbines
private static void removeWindTurbines(EnergySystem energySystem, Scanner scanner) {
    System.out.println("Enter the ID of the wind turbine to remove: ");
    String id = scanner.nextLine();

    // Iterate through the energy resources to find and remove the wind turbine
    boolean removed = false;
    for (EnergyResource resource : energySystem.energyResources) {
        if (resource instanceof WindTurbine && resource.getId().equals(id)) {
            energySystem.removeEnergyResource(resource);
            removed = true;
            break; // Stop searching after finding and removing the wind turbine
        }
    }

    if (removed) {
        System.out.println("Wind turbine with ID " + id + " has been removed.");
    } else {
        System.out.println("Wind turbine with ID " + id + " not found.");
    }
}

private static void removeHydroGenerators(EnergySystem 
energySystem, Scanner scanner)  {
    System.out.println("Enter the ID of the hydroelectric generator to remove: ");
    String id = scanner.nextLine();

    // Iterate through the energy resources to find and remove the hydroelectric generator
    boolean removed = false;
    for (EnergyResource resource : energySystem.energyResources) {
        if (resource instanceof HydroelectricGenerator && resource.getId().equals(id)) {
            energySystem.removeEnergyResource(resource);
            removed = true;
            break; // Stop searching after finding and removing the hydroelectric generator
        }
    }

    if (removed) {
        System.out.println("Hydroelectric generator with ID " + id + " has been removed.");
    } else {
        System.out.println("Hydroelectric generator with ID " + id + " not found.");
    }
}
    private static int getValidInput(Scanner scanner, int max) {
        int input = 0;
        boolean valid = false;
        while (!valid) {
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input >= 1 && input <= max) {
                    valid = true;
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and " + max + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Consume the invalid input
            }
        }
        scanner.nextLine(); // Consume the newline character
        return input;
    }
    private static void calculateTotalEnergyProduction(Scanner scanner, EnergySystem energySystem) {
        double totalProduction = energySystem.calculateTotalEnergyProduction();
        System.out.println("Total Energy Production: " + totalProduction + " kWh");
    }
    private static void calculateConsumption(Scanner scanner, EnergySystem energySystem) {
        // Ask for active time hours
        System.out.print("Enter the active time hours: ");
        double activeTimeHours = getDoubleInput(scanner);

        // Ask for power consumption
        System.out.print("Enter the power consumption: ");
        double powerConsumption = getDoubleInput(scanner);
        
        System.out.println(energySystem.calculateTotalEnergyConsumption(activeTimeHours, powerConsumption) + " kWh");
    }

    private static double getDoubleInput(Scanner scanner) {
        double input = 0.0;
        boolean valid = false;
        while (!valid) {
            if (scanner.hasNextDouble()) {
                input = scanner.nextDouble();
                valid = true;
            } else if (scanner.hasNextInt()) {
                input = (double) scanner.nextInt(); // Convert the integer input to double
                valid = true;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Consume the invalid input
            }
        }
        scanner.nextLine(); // Consume the newline character
        return input;

    }
    
}
