#FROM openjdk:8-jdk-alpine
#FROM openjdk:17-jdk-alpine
#FROM adoptopenjdk/openjdk11:alpine-jre
FROM openjdk:17-jdk-alpine
ADD target/JavaSelenium-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
