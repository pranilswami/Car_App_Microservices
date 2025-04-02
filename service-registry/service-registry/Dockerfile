FROM openjdk:25-slim-bullseye

# Set working directory
WORKDIR /app

ADD target/service-registry.jar service-registry.jar

EXPOSE 8761

# Run the application
ENTRYPOINT ["java", "--enable-native-access=ALL-UNNAMED", "-jar", "service-registry.jar"]
