FROM openjdk:25-slim-bullseye

# Set working directory
WORKDIR /app

COPY target/car-service.jar car-service.jar

EXPOSE 8082

# Run the application
ENTRYPOINT ["java", "-jar", "car-service.jar"]