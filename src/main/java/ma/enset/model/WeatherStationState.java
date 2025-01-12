package ma.enset.model;

public record WeatherStationState(
                    long count,
                    double temperatures,
                    double humidities
                     ) {

    public static WeatherStationState initialize(){
        return new WeatherStationState(0L, 0.0, 0.0);
    }

    public WeatherStationState update(Weather weather){
        return new WeatherStationState(
                count + 1,
                temperatures + weather.temperature(),
                humidities + weather.humidity()
        );
    }

    public String summarize(String station){
        return String.format(
                "station: %s, MT: %.2f Fah, MH: %.2f %%",
                station,
                temperatures / count,
                humidities / count
        );
    }

}
