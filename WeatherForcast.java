import java.util.Random;

public class WeatherForecast {
    private Sensor sensor;

    // Constructor
    public WeatherForecast(Sensor sensor) {
        this.sensor = sensor;
    }

    // Method to retrieve weather forecast data
    public String getWeatherForecast() {
        // Use the sensor data to generate a weather forecast
        double sunlightIntensity = sensor.getSunlightIntensity();
        double windSpeed = sensor.getWindSpeed();

        // Perform calculations or use algorithms to predict weather conditions
        // For demonstration purposes, let's assume a simple random forecast
        Random random = new Random();
        boolean sunny = random.nextBoolean();
        boolean windy = random.nextBoolean();

        // Construct the forecast message
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

    // Method to provide forecasts to SolarPanel class
    public void provideSolarForecast(SolarPanel solarPanel) {
        // Get weather data from the sensor and adjust solar panel settings accordingly
        double sunlightIntensity = sensor.getSunlightIntensity();
        solarPanel.adjustOrientation(sunlightIntensity); // Adjust orientation based on sunlight intensity
    }

    // Method to provide forecasts to WindTurbine class
    public void provideWindForecast(WindTurbine windTurbine) {
        // Get weather data from the sensor and adjust wind turbine settings accordingly
        double windSpeed = sensor.getWindSpeed();
        windTurbine.adjustBladeLength(windSpeed); // Adjust blade length based on wind speed
    }
}
