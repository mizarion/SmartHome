package com.smarthome.rabbit.publisher_subscriber;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PublisherConfig {

    public static final String queueName_1 = "smarthome.rabbit.publisher-1";
    public static final String queueName_2 = "smarthome.rabbit.publisher-2";
    public static final String exchangeName = "smarthome.rabbit.exchange";

    @Bean
    Queue publisher_queue1() {
        return new Queue(queueName_1, false);
    }

    @Bean
    Queue publisher_queue2() {
        return new Queue(queueName_2, false);
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(exchangeName);
    }

    @Bean
    public Binding binding1() {
        return BindingBuilder.bind(publisher_queue1()).to(fanoutExchange());
    }

    @Bean
    public Binding binding2() {
        return BindingBuilder.bind(publisher_queue2()).to(fanoutExchange());
    }
}
