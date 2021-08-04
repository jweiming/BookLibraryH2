FROM openjdk:8-jre-alpine
WORKDIR /usr/spring/booklibrary
COPY ./target/bookLibrary-0.0.1-SNAPSHOT.jar /usr/spring/booklibrary
EXPOSE 8080
CMD ["java", "-jar", "bookLibrary-0.0.1-SNAPSHOT.jar"]