package com.smarthome.rabbit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("test")
public class Controller {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("1")
    public void get() {
        String message = "hello world";
        rabbitTemplate.convertAndSend(Config.queueName, message);
        log.info("send: '" + message + "'");
    }
}

