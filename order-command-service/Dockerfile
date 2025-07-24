# Use an official OpenJDK image as a base
FROM openjdk:17-jdk-slim

# Set environment variables
ENV TZ=UTC
ENV JAVA_OPTS=""

# Create a working directory
WORKDIR /app

# Copy the fat JAR file
COPY target/order-command-service-0.0.1-SNAPSHOT.jar app.jar

# Expose port (matches your Spring Boot app)
EXPOSE 8080

# Healthcheck for container runtime (optional)
HEALTHCHECK --interval=30s --timeout=10s --start-period=40s CMD curl -f http://localhost:8080/actuator/health || exit 1

# Run the app
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app/app.jar"]
