package com.smarthome.rabbit.workers;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WorkersConfig {

    static final String queueName = "smarthome.rabbit.workers";

    @Bean
    Queue workers_queue() {
        return new Queue(queueName, false);
    }
}
