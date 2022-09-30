package com.smarthome.sensor.controller;

import com.smarthome.sensor.model.SensorModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;


@RestController
@RequestMapping("api/example")
@Slf4j
public class ExampleController {
    @Autowired
    private Environment environment;

    @GetMapping
    public ResponseEntity<SensorModel> getSensor() {

        SensorModel sensorModel = new SensorModel();
        sensorModel.setPort(Integer.parseInt(Objects.requireNonNull(environment.getProperty("server.port"))));
        return ResponseEntity.ok(sensorModel);
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
