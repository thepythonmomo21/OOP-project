package EnergyResourcesManagment;
import java.util.List;
import java.util.ArrayList;

public class EnergyManagementSystem {
    private EnergySystem energySystem;
    private EnergyDemand energyDemand;
    private List<Battery> batteries;

    public EnergyManagementSystem(EnergySystem energySystem, EnergyDemand energyDemand) {
        this.energySystem = energySystem;
        this.energyDemand = energyDemand;
        this.batteries = new ArrayList<>();
    }

    // Method to add a battery to the energy management system
    public void addBattery(Battery battery) {
        batteries.add(battery);
    }

    // Method to remove a battery from the energy management system
    public void removeBattery(Battery battery) {
        batteries.remove(battery);
    }

    // Method to get the total number of batteries in the energy management system
    public int getBatteryCount() {
        return batteries.size();
    }

    // Method to adjust production levels based on energy demand and available resources
    public void adjustProductionLevels() {
        double totalEnergyProduction = energySystem.calculateTotalEnergyProduction();
        double totalEnergyDemand = energyDemand.calculateEnergyDemand();
        double excessEnergy = totalEnergyProduction - totalEnergyDemand;

        // If there is excess energy, store it in batteries
        if (excessEnergy > 0) {
            storeExcessEnergy(excessEnergy);
        }
    }

    // Method to store excess energy in batteries
    private void storeExcessEnergy(double excessEnergy) {
        for (Battery battery : batteries) {
            double remainingCapacity = battery.getMaxCapacity() - battery.getCurrentCapacity();
            if (remainingCapacity > 0) {
                double energyToStore = Math.min(remainingCapacity, excessEnergy);
                battery.charge(energyToStore);
                excessEnergy -= energyToStore;
            }
            if (excessEnergy <= 0) {
                break; // Stop storing energy if excess energy is fully utilized
            }
        }
    }

    // Method to manage energy flow between different components
    public void manageEnergyFlow() {
        // Get the current energy production from the energy system
        double currentEnergyProduction = energySystem.calculateTotalEnergyProduction();
        
        // Get the current energy demand
        double currentEnergyDemand = energyDemand.calculateEnergyDemand();
        
        // Check if there is enough energy production to meet the demand
        if (currentEnergyProduction >= currentEnergyDemand) {
            // If energy production exceeds demand, satisfy the demand and store excess energy
            double excessEnergy = currentEnergyProduction - currentEnergyDemand;
            storeExcessEnergy(excessEnergy);
        } else {
            // If energy production is insufficient to meet the demand, adjust production levels
            adjustProductionLevels();
        }
    }
}