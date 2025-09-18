package com.example.sensordataflinkjob.serialisation;
import org.apache.flink.api.common.serialization.DeserializationSchema;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import java.io.IOException;

public class SensorDeserializer implements DeserializationSchema<SensorReading> {

    @Override
    public SensorReading deserialize(byte[] message) throws IOException {
        String[] parts = new String(message).split(",");
        String sensorId = parts[0];
        double temp = Double.parseDouble(parts[1]);
        long ts = Long.parseLong(parts[2]);
        return new SensorReading(sensorId, temp, ts);
    }

    @Override
    public boolean isEndOfStream(SensorReading nextElement) { return false; }

    @Override
    public TypeInformation<SensorReading> getProducedType() {
        return TypeInformation.of(SensorReading.class);
    }
}
