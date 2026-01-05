package com.mycompany.notifications;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

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
    private NotificationMetrics metrics;

    /**
     * Listens to the "order-queue" RabbitMQ queue
     * This method is called automatically when a new message arrives
     * 
     * @param message The JSON message from RabbitMQ
     */
    @RabbitListener(queues = "order-queue")
    public void handleOrderEvent(String message) {
        metrics.incrementRabbit();
        System.out.println("\n🐰 ========================================");
        System.out.println("   📨 Received Order Event from RabbitMQ!");
        System.out.println("========================================\n");
        System.out.println("Message: " + message);
        System.out.println("\n📧 Sending notification email via RabbitMQ...");
        System.out.println("✅ Notification sent successfully!");
        System.out.println("========================================\n");
        
        // In a real application, you would:
        // 1. Parse the JSON message
        // 2. Extract order details
        // 3. Send email/SMS notification
        // 4. Log the notification
    }
}
