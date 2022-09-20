package com.example.sensor.controller;

import com.example.sensor.model.SensorModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("api/example")
@Slf4j
public class ExampleController {
    @GetMapping
    public ResponseEntity<SensorModel> getSensor() {
        return ResponseEntity.ok(new SensorModel());
    }

    @PostMapping
    public ResponseEntity<SensorModel> postSensor(@Valid SensorModel sensorModel, Errors errors) {
        log.info(sensorModel.toString());
        if (errors.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.ok(
                SensorModel.builder()
                        .humidity(sensorModel.getHumidity())
                        .temperature(sensorModel.getTemperature())
                        .build()
        );
    }
}
