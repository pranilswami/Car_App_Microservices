FROM openjdk:21-slim

# Set working directory
WORKDIR /app

ADD target/notification-service.jar notification-service.jar

EXPOSE 8085

# Run the application
ENTRYPOINT ["java","-jar", "notification-service.jar"]