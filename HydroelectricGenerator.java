package EnergyResourcesManagment;

public class HydroelectricGenerator extends AbstractEnergyResource {
	  private double waterFlowRate;
	  private double head;
	  private String Status ; 
	  public HydroelectricGenerator(String id, double efficiency, double head) {
	        super(id, efficiency);
	        this.head = head;
	        Status = "Active" ;
	    }
	    public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
		public double getWaterFlowRate() {
	        return waterFlowRate;
	    }
	    public void setWaterFlowRate(double waterFlowRate) {
	        this.waterFlowRate = waterFlowRate;
	    }
	    public double getHead() {
	        return head;
	    }
	    public void setHead(double head) {
	        this.head = head;
	    }
	    @Override
	    public double calculateEnergyProduction() {
	      
	        double gravitationalConstant = 9.81;
	        double adjustedEfficiency = getEfficiency() * 0.9; 
	        return waterFlowRate * gravitationalConstant * head * adjustedEfficiency;
	    }
	  @Override
	  public double calculateEnergyConsumption(double activeTimeHours, double powerConsumption) {
	      
	        double energyConsumed = powerConsumption * activeTimeHours;
	        return energyConsumed;
	    }
	  @Override
	  public double calculateEfficiency() {
	      
	      double adjustedEfficiency = getEfficiency() * 0.9;
	      return adjustedEfficiency;
	  }
		  
	  
	  
	    
	}