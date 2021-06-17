FROM openjdk:11.0.7-jdk-slim

WORKDIR "/home"

COPY target/Dockertheory.jar /Dockertheory.jar

ENV TZ Europe/Moscow

ENTRYPOINT ["java", "-jar", "/Dockertheory.jar"]
