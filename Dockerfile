FROM maven:3.6.3-jdk-11

WORKDIR "/home"

COPY ./ /home/

RUN mvn clean package

ENTRYPOINT ["java", "-jar", "target/Dockertest.jar"]
