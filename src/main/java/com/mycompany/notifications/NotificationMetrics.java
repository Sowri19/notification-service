package com.mycompany.notifications;

import org.springframework.stereotype.Component;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

/**
 * NotificationMetrics - custom counters for incoming events.
 */
@Component
public class NotificationMetrics {

    private final Counter kafkaEvents;
    private final Counter rabbitEvents;

    public NotificationMetrics(MeterRegistry registry) {
        this.kafkaEvents = Counter.builder("notification_service_kafka_events_total")
            .description("Number of order events consumed from Kafka")
            .register(registry);
        this.rabbitEvents = Counter.builder("notification_service_rabbit_events_total")
            .description("Number of order events consumed from RabbitMQ")
            .register(registry);
    }

    public void incrementKafka() {
        kafkaEvents.increment();
    }

    public void incrementRabbit() {
        rabbitEvents.increment();
    }
}
