package com.example.sensordataproducer.controller;

import com.example.sensordataproducer.service.SensorProducerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SensorProducerController {

    private final SensorProducerService producerService;

    public SensorProducerController(SensorProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping("/send")
    public String sendSensor() {
        producerService.sendRandomSensorReading();
        return "Sensor data sent!";
    }
}
