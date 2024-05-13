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

    public void addBattery(Battery battery) {
        batteries.add(battery);
    }

    public void removeBattery(Battery battery) {
        batteries.remove(battery);
    }

    public int getBatteryCount() {
        return batteries.size();
    }

    public void adjustProductionLevels() {
        double totalEnergyProduction = energySystem.calculateTotalEnergyProduction();
        double totalEnergyDemand = energyDemand.calculateTotalEnergyDemand();
        double excessEnergy = totalEnergyProduction - totalEnergyDemand;
        

        if (excessEnergy > 0) {
            storeExcessEnergy(excessEnergy);
        }
    }

    private void storeExcessEnergy(double excessEnergy) {
        for (Battery battery : batteries) {
            double remainingCapacity = battery.getMaxCapacity() - battery.getCurrentCapacity();
            if (remainingCapacity > 0) {
                double energyToStore = Math.min(remainingCapacity, excessEnergy);
                battery.charge(energyToStore);
                excessEnergy -= energyToStore;
            }
            if (excessEnergy <= 0) {
                break;
            }
        }
    }

    public void manageEnergyFlow() {
        double currentEnergyProduction = energySystem.calculateTotalEnergyProduction();
        double currentEnergyDemand = energyDemand.calculateTotalEnergyDemand();
        if (currentEnergyProduction >= currentEnergyDemand) {
            double excessEnergy = currentEnergyProduction - currentEnergyDemand;
            storeExcessEnergy(excessEnergy);
        } else {
            adjustProductionLevels();
        }
    }
}
