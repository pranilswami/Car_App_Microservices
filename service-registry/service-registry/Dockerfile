FROM openjdk:17

# Set working directory
WORKDIR /app

ADD target/service-registry.jar service-registry.jar

EXPOSE 8761

# Run the application
ENTRYPOINT ["java","-jar", "service-registry.jar"]
