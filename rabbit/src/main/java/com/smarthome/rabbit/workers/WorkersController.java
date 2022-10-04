package com.smarthome.rabbit.workers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("workers")
public class WorkersController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping()
    public void send10() {
        for (int i = 0; i < 10; i++) {
            String message = "hello world " + i;
            rabbitTemplate.convertAndSend(WorkersConfig.queueName, message);
            log.info("send: '" + message + "'");
        }
    }


}

