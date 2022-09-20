package com.example.web;

//import com.example.sensor.model.SensorModel;

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
public class SensorController {

    public static final String url = "http://localhost:8081/api/example";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("1")
    ResponseEntity<String> getSensor() {
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        System.out.println(response);
        return response;
    }

    @GetMapping("2")
    ResponseEntity<String> postSensor() throws URISyntaxException {
        return restTemplate.postForEntity(new URI(url + "?temperature=50&humidity=20"), null, String.class);
    }

// todo
//    @GetMapping("3")
//    ResponseEntity<SensorModel> exchangeSensor() {
//        SensorModel sensorModel = new SensorModel(30, 50);
//        HttpEntity<SensorModel> request = new HttpEntity<>(sensorModel);
//        return restTemplate.exchange(url, HttpMethod.POST, request, SensorModel.class);
//    }
}
