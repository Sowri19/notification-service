package com.mycompany.notifications.service.impl;

import com.mycompany.notifications.metrics.NotificationMetrics;
import com.mycompany.notifications.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationMetrics metrics;

    @Override
    public void handleKafkaOrderEvent(String message) {
        metrics.incrementKafka();
        System.out.println("\n🔔 ========================================");
        System.out.println("   📨 Received Order Event from Kafka!");
        System.out.println("========================================\n");
        System.out.println("Message: " + message);
        System.out.println("\n📧 Sending notification email...");
        System.out.println("✅ Notification sent successfully!");
        System.out.println("========================================\n");
    }

    @Override
    public void handleRabbitOrderEvent(String message) {
        metrics.incrementRabbit();
        System.out.println("\n🐰 ========================================");
        System.out.println("   📨 Received Order Event from RabbitMQ!");
        System.out.println("========================================\n");
        System.out.println("Message: " + message);
        System.out.println("\n📧 Sending notification email via RabbitMQ...");
        System.out.println("✅ Notification sent successfully!");
        System.out.println("========================================\n");
    }
}
