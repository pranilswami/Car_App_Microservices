FROM openjdk:25-slim-bullseye

# Set working directory
WORKDIR /app

ADD target/payment-service.jar payment-service.jar

EXPOSE 8084

# Run the application
ENTRYPOINT ["java", "-jar", "payment-service.jar"]