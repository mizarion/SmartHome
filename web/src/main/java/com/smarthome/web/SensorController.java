package com.smarthome.web;

import com.smarthome.sensor.model.SensorModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("test")
@Slf4j
public class SensorController {
    private static final String SENSOR_URL = "http://localhost:8081/api/example";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("1")
    public ResponseEntity<String> getSensor() {
        ResponseEntity<String> response = restTemplate.getForEntity(SENSOR_URL, String.class);
        log.info(response.toString());
        return response;
    }

    @GetMapping("2")
    public ResponseEntity<String> postSensor() throws URISyntaxException {
        return restTemplate.postForEntity(new URI(SENSOR_URL + "?temperature=50&humidity=20"), null, String.class);
    }

    @GetMapping("3")
    ResponseEntity<SensorModel> exchangeSensor() {
        HttpEntity<SensorModel> modelEntity = new HttpEntity<>(
                SensorModel.builder()
                        .temperature(30)
                        .humidity(50)
                        .build()
        );
        return restTemplate.exchange(SENSOR_URL, HttpMethod.POST, modelEntity, SensorModel.class);
    }
}
