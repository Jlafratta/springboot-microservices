FROM maven:3.8.4-jdk-11-slim as maven
ARG MVN_ENV
RUN mvn clean package spring-boot:repackage -Dmaven.test.skip=true

FROM openjdk:11
ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]

EXPOSE 8081