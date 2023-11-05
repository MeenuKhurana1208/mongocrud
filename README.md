## About The Project

This is a simple application to demonstrate CRUD operations using Mongo DB

Currently only 3 employees are configured, however new employees can be created via the REST Endpoint.

![img_1.png](img_1.png)

## Requirements

The project requires [Java 21](https://www.oracle.com/java/technologies/downloads/#java21).

The project makes use of Maven for build.

The project makes use of [Docker](https://www.docker.com/products/docker-desktop/) for Test Containers, please make sure Docker is installed before build and start of the application

## Useful Maven commands

The project makes use of Maven and uses the Maven to help you out carrying some common tasks such as building
the project or running it.

### List all Maven tasks

List all the tasks that Maven can do, such as `build` and `test`.

```console
$ ./mvn help
```

### Build the project using Maven

Compiles the project, runs the test and then creates an executable JAR file

```console
$ ./mvn clean install
```

### Build the Docker image

Creates the Docker image

```console
$ ./docker build -t example/mongocrud:latest .
```

### Run the application

Run the application using Java and the executable JAR file produced by the Maven `clean install` task. The application will be
listening to port `8080`.

```console
$ java -jar target/mongocrud-application-0.0.1-SNAPSHOT.jar
```

### Run application from Docker

Creates the Docker image

```console
$ ./docker compose -f docker-compose.yml up
```

### Swagger URL

http://localhost:8080/swagger-ui/index.html
