FROM openjdk:25-slim-bullseye

# Set working directory
WORKDIR /app

COPY target/api-gateway.jar api-gateway.jar

EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "api-gateway.jar"]