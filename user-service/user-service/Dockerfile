FROM openjdk:25-slim-bullseye

# Set working directory
WORKDIR /app

COPY target/user-service.jar user-service.jar

EXPOSE 8081

# Run the application
ENTRYPOINT ["java", "-jar", "user-service.jar"]