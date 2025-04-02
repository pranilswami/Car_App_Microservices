FROM openjdk:21-slim

# Set working directory
WORKDIR /app

ADD target/user-service.jar user-service.jar

EXPOSE 8081

# Run the application
ENTRYPOINT ["java","-jar", "user-service.jar"]