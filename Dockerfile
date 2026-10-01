FROM eclipse-temurin:25-jre-alpine

WORKDIR /usr/src/

COPY target/demo.jar demo.jar

EXPOSE 8080