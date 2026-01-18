package com.mycompany.notifications.service;

public interface NotificationService {
    void handleKafkaOrderEvent(String message);
    void handleRabbitOrderEvent(String message);
}
