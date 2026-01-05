package com.mycompany.notifications;

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

    /**
     * Listens to the "order-events" Kafka topic
     * This method is called automatically when a new message arrives
     * 
     * @param message The JSON message from Kafka
     */
    @KafkaListener(topics = "order-events", groupId = "notification-service-group")
    public void handleOrderEvent(String message) {
        System.out.println("\n🔔 ========================================");
        System.out.println("   📨 Received Order Event from Kafka!");
        System.out.println("========================================\n");
        System.out.println("Message: " + message);
        System.out.println("\n📧 Sending notification email...");
        System.out.println("✅ Notification sent successfully!");
        System.out.println("========================================\n");
        
        // In a real application, you would:
        // 1. Parse the JSON message
        // 2. Extract order details
        // 3. Send email/SMS notification
        // 4. Log the notification
    }
}

