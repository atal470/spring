FROM openjdk:11-jdk-slim

WORKDIR /app

COPY target/spring-boot-docker.jar .

CMD ["java", "-jar", "spring-boot-docker.jar"]
