FROM openjdk:25-slim-bullseye

# Set working directory
WORKDIR /app

ADD target/user-service.jar user-service.jar

EXPOSE 8081

# Run the application
ENTRYPOINT ["java","--enable-native-access=ALL-UNNAMED", "-jar", "user-service.jar"]