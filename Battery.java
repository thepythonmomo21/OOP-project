package EnergyResourcesManagment;

public class Battery {
	 private String id;
	    private double maxCapacity;
	    private double currentCapacity;

	  
	    public Battery(String id, double maxCapacity) {
	        this.id = id;
	        this.maxCapacity = maxCapacity;
	        this.currentCapacity = 0.0; // Initially, the battery is empty
	    }
	    public double getCharge() {
	        return currentCapacity;
	    }
	    
	    public String getId() {
	        return id;
	    }

	   
	    public double getMaxCapacity() {
	        return maxCapacity;
	    }

	  
	    public double getCurrentCapacity() {
	        return currentCapacity;
	    }

	 
	    public void charge(double energy) {
	        
	        currentCapacity = Math.min(currentCapacity + energy, maxCapacity);
	    }

	    
	    public void discharge(double energy) {
	       
	        currentCapacity = Math.max(currentCapacity - energy, 0);
	    }
	}


