package com.mycompany.notifications.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RabbitMQOrderListener - Listens to RabbitMQ messages from e-commerce service
 * 
 * This service consumes messages from RabbitMQ queue
 * and handles notifications when orders are created.
 * 
 * This is similar to OrderEventListener but uses RabbitMQ instead.
 * Good for learning: Compare Kafka vs RabbitMQ!
 */
@Service
public class RabbitMQOrderListener {

    @Autowired
    private NotificationService notificationService;

    /**
     * Listens to the "order-queue" RabbitMQ queue
     * This method is called automatically when a new message arrives
     * 
     * @param message The JSON message from RabbitMQ
     */
    @RabbitListener(queues = "order-queue")
    public void handleOrderEvent(String message) {
        notificationService.handleRabbitOrderEvent(message);
    }
}
