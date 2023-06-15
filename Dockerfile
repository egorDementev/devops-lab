FROM maven:3.8.4-openjdk-17 AS builder

WORKDIR /app

COPY src /app/src
COPY pom.xml /app/pom.xml

RUN mvn clean package

FROM openjdk:17-jdk-slim

COPY --from=builder /app/target/DevopsLab1-1.0-SNAPSHOT.jar /app/my-app.jar

CMD ["java", "-jar", "/app/my-app.jar"]