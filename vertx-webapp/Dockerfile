FROM openjdk:8-alpine
EXPOSE 8085
COPY target/vertx-webapp-1.0-SNAPSHOT.jar vertx-webapp-1.0-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "vertx-webapp-1.0-SNAPSHOT.jar"]