package EnergyResourcesManagment;

import java.util.ArrayList;

public class EnergySystem {
    private ArrayList<EnergyResource> energyResources;
    private Battery battery;

    // Constructor
    public EnergySystem(String batteryId, double batteryMaxCapacity) {
        energyResources = new ArrayList<>();
        battery = new Battery(batteryId, batteryMaxCapacity);
    }

    // Method to add an energy resource to the system
    public void addEnergyResource(EnergyResource resource) {
        energyResources.add(resource);
    }

    // Method to remove an energy resource from the system
    public void removeEnergyResource(EnergyResource resource) {
        energyResources.remove(resource);
    }

    // Method to calculate total energy production of the system
    public double calculateTotalEnergyProduction() {
        double totalProduction = 0;
        for (EnergyResource resource : energyResources) {
            totalProduction += resource.calculateEnergyProduction();
        }
        return totalProduction;
    }

    // Method to calculate total energy consumption of the system
    public double calculateTotalEnergyConsumption(double activeTimeHours, double powerConsumption) {
        double totalConsumption = 0;
        for (EnergyResource resource : energyResources) {
            totalConsumption += resource.calculateEnergyConsumption(activeTimeHours, powerConsumption);
        }
        return totalConsumption;
    }


    // Method to optimize energy usage based on demand and available resources
    
    }

