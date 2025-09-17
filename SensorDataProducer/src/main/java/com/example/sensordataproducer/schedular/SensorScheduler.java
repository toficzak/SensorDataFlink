package com.example.sensordataproducer.schedular;
import com.example.sensordataproducer.service.SensorProducerService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SensorScheduler {
    private final SensorProducerService producerService;

    public SensorScheduler(SensorProducerService producerService) {
        this.producerService = producerService;
    }

    @Scheduled(fixedRate = 1000)
    public void sendPeriodic() {
        producerService.sendRandomSensorReading();
    }
}
