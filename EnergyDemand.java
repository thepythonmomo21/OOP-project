package EnergyResourcesManagment;

public class EnergyDemand {
    
    private double industrialPower;
    private double residentialPower;

    public EnergyDemand(double industrialPower, double residentialPower) {
        this.industrialPower = industrialPower;
        this.residentialPower = residentialPower;
    }

    public double calculateTotalEnergyDemand() {
        double demandPerIndustrialUnit = 500;
        double demandPerResidentialUnit = 750;

        double totalDemand = (industrialPower * demandPerIndustrialUnit) + (residentialPower * demandPerResidentialUnit);
        return totalDemand;
    }

    public String compareWithProduction(double production) {
        double demand = calculateTotalEnergyDemand();
        if (demand > production) {
            return "Energy demand exceeds production";
        } else if (demand < production) {
            return "Energy production exceeds demand";
        } else {
            return "Energy production matches demand";
        }
    }

    public void adjustEnergyDemand(double industrialFactor, double residentialFactor) {
        industrialPower *= industrialFactor;
        residentialPower *= residentialFactor;
    }
}
