package com.mycompany.notifications.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * NotificationController - REST API for notification service
 * 
 * This provides endpoints to check the health and status
 * of the notification service.
 */
@RestController
public class NotificationController {

    /**
     * GET /health
     * Health check endpoint
     */
    @GetMapping("/health")
    public String health() {
        return "Notification Service is running! ✅";
    }

    /**
     * GET /api/notifications/status
     * Get service status
     */
    @GetMapping("/api/notifications/status")
    public String getStatus() {
        return "{\"status\":\"active\",\"service\":\"notification-service\",\"listening\":\"order-events\"}";
    }
}

