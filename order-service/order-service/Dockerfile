FROM openjdk:25-slim-bullseye

# Set working directory
WORKDIR /app

ADD target/order-service.jar order-service.jar

EXPOSE 8083

# Run the application
ENTRYPOINT ["java", "-jar", "order-service.jar"]