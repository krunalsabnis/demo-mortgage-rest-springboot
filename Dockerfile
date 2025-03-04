FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

COPY build/libs/*.jar app.jar

EXPOSE 8080

# Default JVM options can be overridden at runtime
ENV JVM_OPTS=""

ENTRYPOINT exec java $JVM_OPTS -jar app.jar
