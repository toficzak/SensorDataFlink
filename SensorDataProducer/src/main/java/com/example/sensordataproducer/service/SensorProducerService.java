package com.example.sensordataproducer.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class SensorProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final Random random = new Random();

    public SensorProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendRandomSensorReading() {
        String sensorId = "sensor-" + (random.nextInt(3) + 1);
        double temp = 20 + random.nextDouble() * 15;
        long ts = System.currentTimeMillis();
        String message = sensorId + "," + temp + "," + ts;
        kafkaTemplate.send("sensors", sensorId, message);
        System.out.println("Produced: " + message);
    }
}