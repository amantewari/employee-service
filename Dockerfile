FROM openjdk:17-jdk-alpine
ARG JAR=target/employee-service-0.0.1-SNAPSHOT.jar
COPY ${JAR} app.jar
RUN apt-get update && apt-get install -y curl
ENTRYPOINT ["java","-jar","/app.jar"]
