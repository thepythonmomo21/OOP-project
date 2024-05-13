package EnergyResourcesManagment;

public class SolarPanel extends AbstractEnergyResource {
    private double orientation;
    private double surfaceArea;
    private String status ; 
    
	public SolarPanel(String id, double efficiency, double orientation, double surfaceArea) {
        super(id, efficiency);

        if (orientation < 0 || orientation > 360) {
            throw new IllegalArgumentException("Orientation must be between 0 and 360 degrees.");
        }

        if (surfaceArea <= 0) {
            throw new IllegalArgumentException("Surface area must be a positive value.");
        }

        this.orientation = orientation;
        this.surfaceArea = surfaceArea;
    }

    public double getOrientation() {
        return orientation;
    }

    public void setOrientation(double orientation) {
        this.orientation = orientation;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    @Override
    public double calculateEnergyProduction() {
        double incidentSolarIrradiance = 1000;
        return incidentSolarIrradiance * getEfficiency() * surfaceArea;
    }

    @Override
    public double calculateEnergyConsumption(double activeTimeHours, double powerConsumption) {
        // Calculate energy consumption based on active time and power consumption
        return activeTimeHours * powerConsumption;
    }

    @Override
    public double calculateEfficiency() {
        double production = calculateEnergyProduction();
        return 0.9 * production; 
    }

    @Override
    public double getMaxCapacity() {
        return 0.0;
    }

    @Override
    public double getCurrentCapacity() {
        return 0.0;
    }

   

    public String getStatus() {
		return status;
	}

	@Override
    public void setStatus(String status) {
    }

    
}
