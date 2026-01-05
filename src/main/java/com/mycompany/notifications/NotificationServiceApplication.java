package com.mycompany.notifications;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Notification Service - Microservice for handling notifications
 * 
 * This service listens to Kafka messages from the e-commerce service
 * and sends notifications (emails, SMS, etc.) when orders are created.
 */
@SpringBootApplication
public class NotificationServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApplication.class, args);
        
        System.out.println("\n🔔 ========================================");
        System.out.println("   Notification Service Started!");
        System.out.println("========================================\n");
        System.out.println("📡 Server: http://localhost:8081");
        System.out.println("📨 Listening to Kafka topic: order-events");
        System.out.println("💡 This service will receive order notifications");
        System.out.println("========================================\n");
    }
}

