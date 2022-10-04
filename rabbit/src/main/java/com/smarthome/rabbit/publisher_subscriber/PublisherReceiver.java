package com.smarthome.rabbit.publisher_subscriber;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PublisherReceiver {

    @RabbitListener(queues = PublisherConfig.queueName_1)
    public void receive(String message) {
        log.info("receiver-1: '" + message + "'");
    }

    @RabbitListener(queues = PublisherConfig.queueName_2)
    public void receive2(String message) {
        log.info("receiver-2: '" + message + "'");
    }
}