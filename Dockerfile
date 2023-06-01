FROM openjdk:17
WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN dependency:resolve

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]