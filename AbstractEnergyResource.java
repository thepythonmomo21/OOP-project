package EnergyResourcesManagment;

public abstract class AbstractEnergyResource implements EnergyResource {
	 protected String id;
	    protected double efficiency;
	    private boolean active;
	    private double[] location;
	    protected double activeTimeHours ;
	    protected double doublepowerConsumption ;
	    // Constructor
	    public AbstractEnergyResource(String id, double efficiency) {
	        this.id = id;
	        this.efficiency = efficiency;
	        this.active = false; // Initially inactive
	        this.location = new double[2]; // Default location (0, 0)
	    }

	    @Override
	    public abstract double calculateEnergyProduction();

	 
	   

	    @Override
	    public boolean isActive() {
	        return active;
	    }

	    @Override
	    public void activate() {
	        active = true;
	    }

	    @Override
	    public void deactivate() {
	        active = false;
	    }

	    @Override
	    public String getType() {
	        // Abstract method, should be implemented by subclasses
	        return "Unknown";
	    }

	

	    @Override
	    public void setLocation(double latitude, double longitude) {
	        location[0] = latitude;
	        location[1] = longitude;
	    }

	    @Override
	    public double[] getLocation() {
	        return location;
	    }
	 
	      

	        @Override
	        public abstract double calculateEnergyConsumption(double activeTimeHours, double powerConsumption);

	        // ... other methods ...
	    }


	    @Override
	    public double getMaxCapacity() {
	        // Abstract method, should be implemented by subclasses
	        return 0.0;
	    }

	    @Override
	    public double getCurrentCapacity() {
	        // Abstract method, should be implemented by subclasses
	        return 0.0;
	    }

	    @Override
	    public double getEfficiency() {
	        return efficiency;
	    }

	    @Override
	    public void setEfficiency(double efficiency) {
	        this.efficiency = efficiency;
	    }

	    @Override
	    public String getStatus() {
	        // Abstract method, should be implemented by subclasses
	        return "Unknown";
	    }

	    @Override
	    public void setStatus(String status) {
	        // Abstract method, should be implemented by subclasses
	    }

	    @Override
	    public double calculatePaybackPeriod(double initialCost, double energySavingsPerYear) {
	        // Abstract method, should be implemented by subclasses
	        return 0.0;
	    }

	    @Override
	    public double calculateNetEnergyProduction() {
	        // Abstract method, should be implemented by subclasses
	        return 0.0;
	    }

	    @Override
	    public double calculateEfficiency() {
	        // Abstract method, should be implemented by subclasses
	        return 0.0;
	    }
	}


