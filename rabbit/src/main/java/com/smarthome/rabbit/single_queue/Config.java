package com.smarthome.rabbit.single_queue;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    static final String queueName = "smarthome.rabbit";

    @Bean
    Queue single_queue() {
        return new Queue(queueName, false);
    }
}
