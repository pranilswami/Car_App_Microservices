FROM openjdk:25-slim-bullseye

# Set working directory
WORKDIR /app

ADD target/api-gateway.jar api-gateway.jar

EXPOSE 8080

# Run the application
ENTRYPOINT ["java","--enable-native-access=ALL-UNNAMED", "-jar", "api-gateway.jar"]