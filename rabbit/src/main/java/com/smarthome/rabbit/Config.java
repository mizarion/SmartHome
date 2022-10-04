package com.smarthome.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    static final String queueName = "smarthome.rabbit";

    @Bean
    Queue queue() {
        return new Queue(queueName, false);
    }
}
