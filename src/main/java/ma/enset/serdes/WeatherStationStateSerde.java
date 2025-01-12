package ma.enset.serdes;

import ma.enset.model.WeatherStationState;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

class WeatherStationStateSerde implements Serde<WeatherStationState> {


    private final WeatherStationStateSerializer
            weatherStationStateSerializer = new WeatherStationStateSerializer();

    private final WeatherStationStateDeserializer weatherStationStateDeserializer =
            new WeatherStationStateDeserializer();



    @Override
    public Serializer<WeatherStationState> serializer() {
        return weatherStationStateSerializer;
    }


    @Override
    public Deserializer<WeatherStationState> deserializer() {
        return weatherStationStateDeserializer;
    }

}

class WeatherStationStateSerializer implements Serializer<WeatherStationState> {
    @Override
    public byte[] serialize(String s, WeatherStationState state) {
        return SerdesUtils.write(state);
    }
}

class WeatherStationStateDeserializer implements Deserializer<WeatherStationState> {

    @Override
    public WeatherStationState deserialize(String s, byte[] bytes) {
        return SerdesUtils.read(bytes, WeatherStationState.class);
    }
}
