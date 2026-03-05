# Приют для животных (Микросервисы)

## Архитектура
- **animal-service** (порт 8081) — управление данными о животных.
- **application-service** (порт 8082) — обработка заявок на усыновление.
- **RabbitMQ** — асинхронный обмен сообщениями между сервисами.
- **H2 Database** — in-memory база данных для каждого сервиса.

## Как запустить

1. **Запустить RabbitMQ:**
   ```bash
   docker-compose up -d
2. **Запустить сервисы:**
   - Открыть animal-service в IntelliJ IDEA → запустить AnimalServiceApplication.
   - Открыть application-service в IntelliJ IDEA → запустить ApplicationServiceApplication.
3. **Проверить работу:**
    - Животные: http://localhost:8081/animals
    - Заявки: http://localhost:8082/applications
    - H2 Console: http://localhost:8081/h2-console
    - RabbitMQ: http://localhost:15672

## Технологии
- Java 17
- Spring Boot 4.0.3
- Spring AMQP (RabbitMQ)
- Maven
- Lombok
