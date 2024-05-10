package EnergyResourcesManagment;

public class Battery {
	 private String id;
	    private double maxCapacity;
	    private double currentCapacity;

	    // Constructor
	    public Battery(String id, double maxCapacity) {
	        this.id = id;
	        this.maxCapacity = maxCapacity;
	        this.currentCapacity = 0.0; // Initially, the battery is empty
	    }
	    public double getCharge() {
	        return currentCapacity;
	    }
	    // Getter for battery ID
	    public String getId() {
	        return id;
	    }

	    // Getter for maximum capacity
	    public double getMaxCapacity() {
	        return maxCapacity;
	    }

	    // Getter for current capacity
	    public double getCurrentCapacity() {
	        return currentCapacity;
	    }

	    // Method to charge the battery with a specified amount of energy
	    public void charge(double energy) {
	        // Ensure that charging does not exceed the maximum capacity
	        currentCapacity = Math.min(currentCapacity + energy, maxCapacity);
	    }

	    // Method to discharge the battery by a specified amount of energy
	    public void discharge(double energy) {
	        // Ensure that discharging does not result in negative capacity
	        currentCapacity = Math.max(currentCapacity - energy, 0);
	    }
	}



