FROM openjdk:25-slim-bullseye

# Set working directory
WORKDIR /app

ADD target/notification-service.jar notification-service.jar

EXPOSE 8085

# Run the application
ENTRYPOINT ["java","--enable-native-access=ALL-UNNAMED", "-jar", "notification-service.jar"]