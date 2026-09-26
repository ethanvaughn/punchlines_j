# Punchlines

Java 25, Spring Boot 4.1.1, Hibernate ORM 7.4.10.Final, and PostgreSQL 18.

## Start

Open this folder in VS Code and run **Dev Containers: Reopen in Container**. The app container includes Java and Maven; PostgreSQL starts alongside it and is health-checked before the app container is ready.

Run the application from the devcontainer terminal:

```sh
mvn spring-boot:run
```

The database is available to the application at `db:5432` and is forwarded to local port `5432`. The application listens on port `8080`.

Local database credentials are `app` / `app`. Hibernate schema auto-update is enabled for development only; use migrations and production-specific settings before deployment.