# Train Station Backend

Backend for student ID `2400031163`, following the general layout of the supplied CRUD project.

## Stack
- Java 21, Spring Boot 3.5.x, Maven
- PostgreSQL
- Spring Data JPA and Bean Validation
- Swagger UI

## Packages
`com.klef.soa.docker.configuration`, `entity`, `repository`, `service`, `service.impl`, `dto`, and `controller`.

## Run locally
1. Start PostgreSQL.
2. Create a database named `TrainStation`.
3. Configure `DB_URL`, `DB_USERNAME`, and `DB_PASSWORD` as environment variables, or update `src/main/resources/application.properties`.
4. Run `mvn spring-boot:run`.

The default local connection uses `jdbc:postgresql://localhost:5432/TrainStation`, username `postgres`, password `docker`. Change these values to match your local database.

Swagger UI: http://localhost:1947/swagger-ui/index.html

## Endpoints
- `POST /station/add`
- `GET /station/displayall`
- `GET /station/displaybyid/{id}`
- `PUT /station/update/{id}`
- `DELETE /station/delete/{id}`

Example JSON (do not include `id`):
```json
{
  "stationName": "Vijayawada Junction",
  "city": "Vijayawada",
  "platformCount": 10,
  "stationCode": "BZA"
}
```
