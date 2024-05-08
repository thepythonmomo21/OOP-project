package com.mycompany.energyresourcesmanagment;

public class SolarPanel implements  EnergyResource {
    private String Id;
    private double Efficiency;
    private double Orientation;
    private double SurfaceArea;
 
   public SolarPanel(String Id, double Orientation, double Efficiency, double SurfaceArea) {
        // Validation for Id
        if (Id == null || Id.isEmpty()) {
            throw new IllegalArgumentException("Id cannot be null or empty.");
        }

        // Validation for Orientation
        if (Orientation < 0 || Orientation > 360) {
            throw new IllegalArgumentException("Orientation must be between 0 and 360 degrees.");
        }

        // Validation for Efficiency
        if (Efficiency <= 0 || Efficiency > 1) {
            throw new IllegalArgumentException("Efficiency must be a positive value less than or equal to 1.");
        }

        // Validation for SurfaceArea
        if (SurfaceArea <= 0) {
            throw new IllegalArgumentException("Surface area must be a positive value.");
        }

        this.Id = Id;
        this.Orientation = Orientation;
        this.Efficiency = Efficiency;
        this.SurfaceArea = SurfaceArea;
    }

  public String getId() {
        return Id;
    }

    public void setId(String id) {
      Id = id;
    }

    public double getEfficiency() {
        return Efficiency;
    }

    public void setEfficiency(double efficiency) {
        Efficiency = efficiency;
    }

    public double getOrientation() {
        return Orientation;
    }

    public void setOrientation(double orientation) {
        Orientation = orientation;
    }

    public double getSurfaceArea() {
        return SurfaceArea;
    }

    public void setSurfaceArea(double surfaceArea) {
        SurfaceArea = surfaceArea;
    }
     
   @Override
    public double calculateEnergyProduction() {
        // Example calculation based on incident solar irradiance
        // Adjust this calculation based on your specific scenario
        double incidentSolarIrradiance = 1000; // Example value (1 kW/m^2)
        return incidentSolarIrradiance * Efficiency * SurfaceArea;
    }

    @Override
    public double calculateEnergyConsumption() {
        // Implementation specific to solar panel (if applicable)
        return 0.0; // Placeholder value
    }
     
    @Override
    public double calculateTotalEfficiency() {
        double production = calculateEnergyProduction();
        return 0.9 * production; 
    }
    
    @Override
    public double calculateNetEnergyProduction(){
       return calculateEnergyProduction() - calculateEnergyConsumption();  
}
    
}
