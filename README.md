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

## Metrics (Prometheus) & Grafana
- Prometheus scrape target: `http://localhost:8081/actuator/prometheus`
- Quick run Prometheus + Grafana:
```bash
docker run -d --name prometheus -p 9090:9090 \
  -v $(pwd)/prometheus.yml:/etc/prometheus/prometheus.yml prom/prometheus
docker run -d --name grafana -p 3000:3000 grafana/grafana-oss:10.3.1
```
Prometheus config example:
```yaml
global:
  scrape_interval: 15s
scrape_configs:
  - job_name: 'notification-service'
    metrics_path: /actuator/prometheus
    static_configs:
      - targets: ['host.docker.internal:8081']
```
Grafana UI: `http://localhost:3000` (admin/admin by default). Add Prometheus datasource at `http://host.docker.internal:9090`.

## Logs with trace correlation (Loki + Promtail)
- Log file: `logs/notification-service.log` with `traceId`/`spanId` in each line.
- Promtail config lives in the order-service repo (`loki-promtail-config.yml`) and already includes this log path.

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
