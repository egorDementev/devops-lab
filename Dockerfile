FROM openjdk:17
WORKDIR /app

COPY .mvn/ .mvn
COPY pom.xml ./
RUN ./mvnw dependency:resolve

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]