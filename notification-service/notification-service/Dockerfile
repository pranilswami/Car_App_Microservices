FROM openjdk:25-slim-bullseye

# Set working directory
WORKDIR /app

COPY target/notification-service.jar notification-service.jar

EXPOSE 8085

# Run the application
ENTRYPOINT ["java", "-jar", "notification-service.jar"]