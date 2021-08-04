## Book Library
Maven based Springboot application.

## Description
Simple CRUD application using Springboot with JPA. This application uses SQL based DB engine for persistence (H2 has been used as an example with this project), feel free to change the SQL-based db as necessary. Micrometer-registry-prometheus is enabled so you can connect prometheus/grafana to scrap metrics from the actuator.

## Technology

- **Spring Boot**     - Server side framework
- **JPA**             - Entity Persistence framework
- **Lombok**          - Provides annotation based automated getter/setters
- **Actuator**        - Application telemetry
- **Devtools**        - Support Hot-Code Swapping with live browser reload
- **Swagger**         - In-built swagger2 documentation support
- **Docker**          - Docker containers
- **Junit**           - Unit testing framework
- **H2**              - H2 database embedded version

## Application Structure

## Running the server locally
The BookLibrary application can be started using your favourite IDE and its run configuration support or terminal using the following command -

````
mvn spring-boot:run
or 
java -jar target/xxx.jar
````

## Docker
BookLibrary supports docker container out of the box. This boilerplate is meant to cater to both web based applications as well as scalable micro services written in Java. Please select one of the following two ways to use docker to build and run the application -

**Dockerfile**

To build a fresh image, use -
````
docker build -t booklibrary .
````
To run the new image, use -
````
docker run -p 8080:8080 booklibrary
````

**Docker-Compose**

To build a fresh image, use -
````
docker-compose build
````
To run the new image, use -
````
docker-compose up
````

## Swagger Documentation
Swagger documentation is enabled and can be accessed at the following URL -
````
http://<host-name>:8080/swagger-ui.html
````

## Unit test cases
There are multiple unit test cases written to cover the different components of the application.

````
mvn clean test 
````

## Metrics
You can access telemetry data (provided by the actuator) with the following url. Prometheus-ready endpoint is provided so you can connect your Prometheus and Grafana to scrap metrics from the application that is Prometheus readable.

````
http://<host-name>:8080/actuator
http://<host-name>:8080/actuator/prometheus
````

## Credits
- Exception classes extracted from https://github.com/SystangoTechnologies/BankOfSpring
