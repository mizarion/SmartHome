package com.smarthome.rabbit.workers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class WorkersReceiver {

    @RabbitListener(queues = WorkersConfig.queueName)
    public void worker1(String message) {
        log.info("workers-1: '" + message + "'");
    }

    @RabbitListener(queues = WorkersConfig.queueName)
    public void worker2(String message) {
        log.info("workers-2: '" + message + "'");
    }
}