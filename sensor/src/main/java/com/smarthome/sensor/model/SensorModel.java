package com.smarthome.sensor.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SensorModel {
    private int temperature;
    @Range(min = 0, max = 100)
    private int humidity;

    private int port;
}
