package EnergyResourcesManagment ; 

public interface EnergyResource {
	
	
	
	double calculateEnergyProduction();
	double calculateEnergyConsumption(double activeTimeHours, double powerConsumption);
	boolean isActive(); 
	void activate();
    void deactivate();           
    void setLocation(double latitude, double longitude);
    double[] getLocation(); 
    double getMaxCapacity();
    double getCurrentCapacity();
    double getEfficiency();
     void setEfficiency(double efficiency);
     
     void setStatus(String status); 
     double calculateEfficiency();

    Object getId();
}



