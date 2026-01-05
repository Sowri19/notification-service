# Notification Service – Kafka & RabbitMQ Consumer

Spring Boot 3 / Java 17 microservice that consumes order events and simulates notifications. It listens to:
- Kafka topic `order-events` (group `notification-service-group`)
- RabbitMQ queue `order-queue`

## Run
```bash
mvn spring-boot:run
# service starts on http://localhost:8081
```

## API docs (Swagger UI)
- Swagger UI: `http://localhost:8081/swagger-ui.html`
- OpenAPI JSON: `http://localhost:8081/v3/api-docs`

## Prerequisites
- Kafka on `localhost:9092` with topic `order-events` (produced by the order-service)
- RabbitMQ on `localhost:5672` (queue `order-queue`)

## Config
`src/main/resources/application.properties`:
- `server.port=8081`
- Kafka bootstrap servers, consumer group, deserializers
- RabbitMQ host/port/credentials

## How it works
- `OrderEventListener`: consumes from Kafka `order-events` and logs receipt (pretending to send email/SMS).
- `RabbitMQOrderListener`: consumes from RabbitMQ `order-queue` similarly.
- `NotificationServiceApplication`: boots the app and prints startup info.

## Test
1) Ensure producers are sending to Kafka/RabbitMQ (e.g., create an order in order-service).
2) Watch logs for messages:
   - Kafka: “📨 Received Order Event from Kafka!”
   - RabbitMQ: “📨 Received Order Event from RabbitMQ!”
