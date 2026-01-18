package com.mycompany.notifications.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * OrderEventListener - Listens to Kafka messages from e-commerce service
 * 
 * This service consumes messages from the "order-events" Kafka topic
 * and handles notifications when orders are created.
 */
@Service
public class OrderEventListener {

    @Autowired
    private NotificationService notificationService;

    /**
     * Listens to the "order-events" Kafka topic
     * This method is called automatically when a new message arrives
     * 
     * @param message The JSON message from Kafka
     */
    @KafkaListener(topics = "order-events", groupId = "notification-service-group")
    public void handleOrderEvent(String message) {
        notificationService.handleKafkaOrderEvent(message);
    }
}
