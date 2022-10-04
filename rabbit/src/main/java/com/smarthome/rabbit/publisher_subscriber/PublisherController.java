package com.smarthome.rabbit.publisher_subscriber;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("publisher")
public class PublisherController {

    private final RabbitTemplate rabbitTemplate;

    public PublisherController() {
        rabbitTemplate = new RabbitTemplate(new CachingConnectionFactory("localhost"));
    }

    @GetMapping()
    public void send() {
        String message = "hello world";
        rabbitTemplate.setExchange(PublisherConfig.exchangeName);
        rabbitTemplate.convertAndSend(message);
        log.info("send: '" + message + "'");
    }
}
