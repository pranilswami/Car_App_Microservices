FROM openjdk:25-slim-bullseye

# Set working directory
WORKDIR /app

ADD target/car-service.jar car-service.jar

EXPOSE 8082

# Run the application
ENTRYPOINT ["java","--enable-native-access=ALL-UNNAMED", "-jar", "car-service.jar"]