package ma.enset.utils;

import ma.enset.model.Weather;
import ma.enset.model.WeatherStationState;
import org.apache.kafka.streams.KeyValue;

public class WeatherFunctions {
    public static Weather from(String weatherString){
        String[] tokens = weatherString.split(",");
        return new Weather(
                tokens[0],
                Double.parseDouble(tokens[1]),
                Double.parseDouble(tokens[2])
        );
    }


    public static Weather mapToFahrenheit(Weather weather){
        double fahrenheit = (weather.temperature() * 9/5) + 32;
        return new Weather(weather.station(), fahrenheit, weather.humidity());
    }


    public static boolean filterWeatherByTemperature(Weather weather){
        return weather.temperature() > 30.0;
    }


    public static void log(String key, Object value, DebuggingStage stage){
        System.out.println("[" + stage + "]: {key: " + key + ", value: " + value + "}");
    }


    public static KeyValue<String, String> summarizeState(String station, WeatherStationState state){
        return new KeyValue<>(station, state.summarize(station));
    }


    public static WeatherStationState weatherStateAggregator(
            String station,
            Weather weather,
            WeatherStationState state){
        return state.update(weather);
    }
}
