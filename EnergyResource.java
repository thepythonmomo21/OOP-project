package EnergyResourcesManagment ; 

public interface EnergyResource {
	
	    // Method to calculate the energy production of the resource
	    double calculateEnergyProduction();

	    // Method to calculate the energy consumption of the resource
	  

	        double calculateEnergyConsumption(double activeTimeHours, double powerConsumption);
	    


	    // Method to check if the resource is currently active or inactive
	    boolean isActive();

	    // Method to activate the resource (e.g., start operation)
	    void activate();

	    // Method to deactivate the resource (e.g., stop operation)
	    void deactivate();

	    // Method to get the type of the energy resource (e.g., solar, wind, hydro)
	    String getType();


	    
	    // Method to set the location of the resource
	    void setLocation(double latitude, double longitude);

	    // Method to get the location of the resource
	    double[] getLocation();

	    // Method to get the maximum energy production capacity of the resource
	    double getMaxCapacity();

	    // Method to get the current energy production capacity of the resource
	    double getCurrentCapacity();

	    // Method to get the efficiency of the resource (e.g., conversion efficiency)
	    double getEfficiency();

	    // Method to set the efficiency of the resource
	    void setEfficiency(double efficiency);

	    // Method to get the current status of the resource (e.g., operating, under maintenance)
	    String getStatus();

	    // Method to update the status of the resource
	    void setStatus(String status);

	    // Method to calculate the payback period of the resource based on initial cost and energy savings
	    double calculatePaybackPeriod(double initialCost, double energySavingsPerYear);

	    // Method to calculate the net energy production (production - consumption) of the resource
	    double calculateNetEnergyProduction();

	    // Method to calculate the efficiency of the resource
	    double calculateEfficiency();
	    // Method to get the water flow rate of the resource (for HydroelectricGenerator)
	     double getWaterFlowRate();
	    // Method to set the water flow rate of the resource (for HydroelectricGenerator)
	    void setWaterFlowRate(double waterFlowRate);
	    // Method to get the head of the resource (for HydroelectricGenerator)
	     double getHead();
	    // Method to set the head of the resource (for HydroelectricGenerator)
             void setHead(double head);

            // Method to get the blade length of the resource (for WindTurbine)
             double getBladeLength();

             // Method to set the blade length of the resource (for WindTurbine)
             void setBladeLength(double bladeLength);

            // Method to get the wind speed of the resource (for WindTurbine)
             double getWindSpeed();

           // Method to set the wind speed of the resource (for WindTurbine)
            void setWindSpeed(double windSpeed);

	
	}



