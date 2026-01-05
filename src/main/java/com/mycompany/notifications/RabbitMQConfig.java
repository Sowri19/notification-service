package com.mycompany.notifications;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMQConfig - Configuration for RabbitMQ Consumer
 * 
 * This class sets up RabbitMQ queue for the notification service.
 * The exchange and binding are created automatically when producer sends first message.
 */
@Configuration
public class RabbitMQConfig {

    // Queue name (must match the producer)
    public static final String QUEUE_NAME = "order-queue";

    /**
     * Creates a Queue
     * This queue will receive messages from the "order-exchange"
     */
    @Bean
    public Queue orderQueue() {
        return new Queue(QUEUE_NAME, true); // true = durable (survives server restart)
    }
}

