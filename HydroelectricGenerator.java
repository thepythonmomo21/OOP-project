public class HydroelectricGenerator extends AbstractEnergyResource {
  private double waterFlowRate;
  private double head;
  public HydroelectricGenerator(String id, double efficiency, double waterFlowRate, double head) {
        super(id, efficiency);
        this.waterFlowRate = waterFlowRate;
        this.head = head;
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
        // Implement energy production calculation specific to hydroelectric generator
        double gravitationalConstant = 9.81;
        return waterFlowRate * gravitationalConstant * head * getEfficiency();
    }
    @Override
    public double calculateNetEnergyProduction() {
        // Implement calculation of net energy production
        // Net energy production = energy production - energy consumption
        return calculateEnergyProduction() - calculateEnergyConsumption();
    }
}
