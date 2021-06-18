FROM openjdk:8-jre-alpine

COPY target/appointment-app-0.0.1.jar /appointment-app.jar

EXPOSE 8080

RUN apk --no-cache add curl

CMD ["java", "-jar", "/appointment-app.jar"]
