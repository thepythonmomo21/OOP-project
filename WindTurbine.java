package EnergyResourcesManagement; 
public class WindTurbine extends AbstractEnergyResource { 
    private double bladelength;
    private double windspeed; 
    public WindTurbine(String id,double efficiency , double bladelength , double windspeed) 
    { super(id,efficiency); 
    this.bladelength=bladelength; 
    this.windspeed=windspeed; } 
    public double getbladelength(){
        return bladelength;
    }
      public void setbladelength( double bladelength)
      {
        this.bladelength=bladelength;
          
      }
      public double getwindspeed(){
          return windspeed;
      }
        public void setwindspeed(double windspeed){
        this.windspeed=windspeed;
      {
             @Override
    public double calculateEnergyProduction() {
        double airDensity = 1.225;
        double area = Math.PI * Math.pow(bladeLength, 2);
        return 0.5 * airDensity * area * windSpeed * windSpeed * windSpeed * powerCoefficient * getEfficiency();
    }

    @Override
    public double calculateEnergyConsumption(double activeTimeHours, double powerConsumption) {
        // Wind turbines generally do not consume energy during operation
        return 0.0;
    }

    @Override
    public double calculateEfficiency() {
        return getEfficiency(); //
    }
    @Override
    public double calculateNetEnergyProduction() {
        return calculateEnergyProduction();
    }
    @Override
    public String getType() {
        return "Wind Turbine";
    }
    @Override
    public double getMaxCapacity() {
        return 0.0; 
    }
    @Override
    public double getCurrentCapacity() {
        return 0.0; //
    }
    @Override
    public String getStatus() {
        return "Unknown";
    }
    @Override
    public void setStatus(String status){
    }
    @Override
    public double calculatePaybackPeriod(double initialCost, double energySavingsPerYear) {
        return 0.0;
    }
}
          
