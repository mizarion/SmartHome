package com.example.sensor.controller;

import com.example.sensor.model.SensorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("api/example")
public class ExampleController {

    @Autowired
    private SensorModel sensorModel;

    @GetMapping
    public ResponseEntity<SensorModel> getSensor() {
        return ResponseEntity.ok(sensorModel);
    }

    @PostMapping
    ResponseEntity<SensorModel> postSensor(@Valid SensorModel sensorModel, Errors errors) {
        System.out.println(sensorModel);
        if (errors.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

        }
        this.sensorModel.setTemperature(sensorModel.getTemperature());
        this.sensorModel.setHumidity(sensorModel.getHumidity());
        return ResponseEntity.ok(sensorModel);
    }
}
