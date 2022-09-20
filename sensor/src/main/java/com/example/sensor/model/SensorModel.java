package com.example.sensor.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Service;

@Data
@Service
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SensorModel {

    int temperature;

    @Range(min = 0, max = 100)
    int humidity;
}
