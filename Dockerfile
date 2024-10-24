FROM gradle:7.6.2-jdk17 AS build
WORKDIR /app
COPY build.gradle settings.gradle /app/
COPY src /app/src
RUN gradle clean build --no-daemon -x test

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
