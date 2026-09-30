# Punchlines

Java 25, Spring Boot 4.1.1, Hibernate ORM 7.4.10.Final, and PostgreSQL 18.

## Devcontainer

This project runs in a devcontainer. All developer tools and dependent programs, like java/javac, Maven, git, Grok Build, Postgres/psql, code/VSCode Server, are set up to run within the container. 


## Start

Open this folder in VS Code and run **Dev Containers: Reopen in Container**. The app container includes Java and Maven; PostgreSQL starts alongside it and is health-checked before the app container is ready.

Run the application from the devcontainer terminal:

```sh
mvn spring-boot:run
```

### Grok Build
Grok Build is installed in the app container. Sign-in, config, and sessions are stored in the `grok-home` volume at `/root/.grok`, so they survive an image rebuild. From the devcontainer terminal:

```sh
grok login --device-auth
grok
```

### PostgreSQL
The database is available to the application at `db:5432` and is forwarded to local port `5432`. The application listens on port `8080`.

Local database credentials are `app` / `app`. Database changes are managed by Flyway migrations in `src/main/resources/db/migration/`; Hibernate validates the migrated schema at startup.

Flyway runs the initial migration automatically when Spring Boot starts.

Connect to the development database from the devcontainer terminal:

```sh
PGPASSWORD=app psql -h db -U app -d appdb
```

Install some starter punchlines:

```sh
PGPASSWORD=app psql -h db -U app -d appdb -f src/dev_sql/lines.sql
```

## Using Hibernate
When troubleshooting SQL statements, view them in the output logs by adding the following line to `src/main/resources/application.properties`:
```
spring.jpa.show-sql=true
```

## GraphQL endpoint
The GraphQL endpoint is available at `http://localhost:8080/graphql`. Query the
Spring health status with:

```sh
curl -X POST http://localhost:8080/graphql \
	-H 'Content-Type: application/json' \
	-d '{"query":"{ health }"}'
```

When the application and PostgreSQL are healthy, the response contains
`{"data":{"health":"UP"}}`. Spring Boot's native health endpoint is also
available at `http://localhost:8080/actuator/health`.

The following curl will test the get_all query:

```sh
curl -X POST http://localhost:8080/graphql \
  -H 'Content-Type: application/json' \
  -d '{"query":"{ get_all { id line insertedAt modifiedAt } }"}'
```
