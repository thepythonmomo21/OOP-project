package EnergyResourcesManagment;

import java.util.ArrayList;

public class EnergySystem {
    public ArrayList<EnergyResource> energyResources;
    private Battery battery;
    private int id;

    public EnergySystem(int id) {
        this.id = id;
        energyResources = new ArrayList<>();
    }

    public void addEnergyResource(EnergyResource resource) {
        energyResources.add(resource);
    }

    public void removeEnergyResource(EnergyResource resource) {
        energyResources.remove(resource);
    }

    public double calculateTotalEnergyProduction() {
        double totalProduction = 0;
        for (EnergyResource resource : energyResources) {
            totalProduction += resource.calculateEnergyProduction();
        }
        return totalProduction;
    }

    public double calculateTotalEnergyConsumption(double activeTimeHours, double powerConsumption) {
        double totalConsumption = 0;
        for (EnergyResource resource : energyResources) {
            totalConsumption += resource.calculateEnergyConsumption(activeTimeHours, powerConsumption);
        }
        return totalConsumption;
    }

    public String printDetails(double production) {
        System.out.println("Energy System ID: " + id);
        System.out.println("Total Energy Production: " + calculateTotalEnergyProduction());
        System.out.println("Total Energy Consumption: " + calculateTotalEnergyConsumption(24, 1000)); // Replace with actual values
        for (EnergyResource resource : energyResources) {
            System.out.println("Resource Efficiency: " + resource.getEfficiency());
            // Add more details as needed...
        }
        return null;
    }

    public void setName(String name) {
    }
}
