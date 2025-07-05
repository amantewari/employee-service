# Use a slim JDK base image
FROM eclipse-temurin:17-jdk-alpine
# Install curl (optional, for debugging)
RUN apk add --no-cache curl
# Set working directory
WORKDIR /app
# Copy the fat JAR file into container
COPY target/employee-service-0.0.1-SNAPSHOT.jar app.jar
# Expose the application port
EXPOSE 9090
# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]

