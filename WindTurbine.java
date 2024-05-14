package EnergyResourcesManagment;

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
        }
        @Override
        public double calculateEnergyProduction() {
            double airDensity = 1.225; // Air density in kg/m^3 (standard value)
            double sweptArea = Math.PI * Math.pow(bladelength, 2); // Swept area of the turbine's blades
            double powerCoefficient = 0.45; // Typical power coefficient for a wind turbine (may vary)
            
            // Calculate the energy production using the formula: 0.5 * airDensity * sweptArea * windspeed^3 * powerCoefficient * efficiency
            return 0.5 * airDensity * sweptArea * Math.pow(windspeed, 3) * powerCoefficient * getEfficiency();
        }

    @Override
    public double calculateEnergyConsumption(double activeTimeHours, double powerConsumption) {
        // Energy consumption = Power consumption * Time of operation
        double energyConsumed = powerConsumption * activeTimeHours;
        return energyConsumed;
    }

    @Override
    public double calculateEfficiency() {
        return getEfficiency(); //
    }

    @Override
    public Object getId() {
        return null;
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
    public void setStatus(String status){
    }
   
}