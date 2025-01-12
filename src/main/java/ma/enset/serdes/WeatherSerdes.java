package ma.enset.serdes;

public class WeatherSerdes{

    public static final WeatherSerde WEATHER_SERDE = new WeatherSerde();


    public static final WeatherStationStateSerde WEATHER_STATION_STATE_SERDE =
            new WeatherStationStateSerde();

    public static WeatherSerde weatherSerde(){
        return WEATHER_SERDE;
    }

    public static WeatherStationStateSerde weatherStateSerde(){
        return WEATHER_STATION_STATE_SERDE;
    }

}
