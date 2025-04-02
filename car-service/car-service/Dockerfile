FROM openjdk:21-slim

# Set working directory
WORKDIR /app

ADD target/car-service.jar car-service.jar

EXPOSE 8082

# Run the application
ENTRYPOINT ["java","-jar", "car-service.jar"]