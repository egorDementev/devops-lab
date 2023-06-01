# Stage 1: Сборка проекта
FROM openjdk:11 AS build
WORKDIR /app
COPY . .
RUN ./gradlew build

# Stage 2: Запуск приложения в контейнере
FROM openjdk:11
WORKDIR /app
COPY --from=build /app/build/libs/your-artifact.jar .
CMD ["java", "-jar", "your-artifact.jar"]