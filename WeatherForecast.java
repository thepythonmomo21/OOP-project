package EnergyResourcesManagment;

import java.util.Random;

public class WeatherForecast {
    private Sensor sensor;


    public WeatherForecast(Sensor sensor) {
        this.sensor = sensor;
    }

   
    public String getWeatherForecast() {
       
        double sunlightIntensity = sensor.getSunlightIntensity();
        double windSpeed = sensor.getWindSpeed();

   
        Random random = new Random();
        boolean sunny = random.nextBoolean();
        boolean windy = random.nextBoolean();

        
        StringBuilder forecast = new StringBuilder("Weather Forecast:\n");
        if (sunny) {
            forecast.append("- Sunny with sunlight intensity: ").append(sunlightIntensity).append("\n");
        } else {
            forecast.append("- Not sunny with sunlight intensity: 0\n");
        }
        if (windy) {
            forecast.append("- Windy with wind speed: ").append(windSpeed).append("\n");
        } else {
            forecast.append("- Not windy with wind speed: 0\n");
        }

        return forecast.toString();
    }


    public void provideSolarForecast(SolarPanel solarPanel) {

        double sunlightIntensity = sensor.getSunlightIntensity();
        solarPanel.getOrientation();
    }

    
    public void provideWindForecast(WindTurbine windTurbine) {
        
        double windSpeed = sensor.getWindSpeed();
        
    }
}