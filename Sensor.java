package EnergyResourcesManagment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sensor {
    private List<Double> sunlightIntensityData;
    private List<Double> windSpeedData;
    private List<Double> waterFlowRateData;
    private double SunlightIntensity;
    private double WindSpeed;
   private double WaterflowRate ; 
   
    public double getWaterflowRate() {
	return WaterflowRate;
}

public void setWaterflowRate(double waterflowRate) {
	WaterflowRate = waterflowRate;
}

	public double getSunlightIntensity() {
        return SunlightIntensity;
    }

    public double getWindSpeed() {
        return WindSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        WindSpeed = windSpeed;
    }

    public void setSunlightIntensity(double sunlightIntensity) {
        SunlightIntensity = sunlightIntensity;
    }

    public Sensor() {
        this.sunlightIntensityData = new ArrayList<>();
        this.windSpeedData = new ArrayList<>();
        this.waterFlowRateData = new ArrayList<>();
    }

    public List<Double> getSunlightIntensityData() {
        return sunlightIntensityData;
    }

    public void setSunlightIntensityData(List<Double> sunlightIntensityData) {
        this.sunlightIntensityData = sunlightIntensityData;
    }

    public List<Double> getWindSpeedData() {
        return windSpeedData;
    }

    public void setWindSpeedData(List<Double> windSpeedData) {
        this.windSpeedData = windSpeedData;
    }

    public List<Double> getWaterFlowRateData() {
        return waterFlowRateData;
    }

    public void setWaterFlowRateData(List<Double> waterFlowRateData) {
        this.waterFlowRateData = waterFlowRateData;
    }

    public void retrieveSensorData() {
        Random random = new Random();
        double sunlightIntensity = random.nextDouble() * 100;
        double windSpeed = random.nextDouble() * 50;
        double waterFlowRate = random.nextDouble() * 10;

        sunlightIntensityData.add(sunlightIntensity);
        windSpeedData.add(windSpeed);
        waterFlowRateData.add(waterFlowRate);
    }

    public double calculateAverageSunlightIntensity() {
        double sum = 0.0;
        for (double intensity : sunlightIntensityData) {
            sum += intensity;
        }
        return sum / sunlightIntensityData.size();
    }

    public double calculateAverageWindSpeed() {
        double sum = 0.0;
        for (double speed : windSpeedData) {
            sum += speed;
        }
        return sum / windSpeedData.size();
    }

    public double calculateAverageWaterFlowRate() {
        double sum = 0.0;
        for (double rate : waterFlowRateData) {
            sum += rate;
        }
        return sum / waterFlowRateData.size();
    }
}
