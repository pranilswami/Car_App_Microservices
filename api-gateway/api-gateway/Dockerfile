FROM openjdk:21-slim

# Set working directory
WORKDIR /app

ADD target/api-gateway.jar api-gateway.jar

EXPOSE 8080

# Run the application
ENTRYPOINT ["java","-jar", "api-gateway.jar"]