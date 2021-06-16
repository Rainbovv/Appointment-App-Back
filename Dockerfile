FROM openjdk:8-jdk-alpine
MAINTAINER stefanini

COPY target/appointment-app-0.0.1-SNAPSHOT.jar appointment-app-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/appointment-app-0.0.1-SNAPSHOT.jar"]