FROM openjdk:11-jdk-slim

WORKDIR /app

COPY target/my-spring-boot-app.jar .

CMD ["java", "-jar", "my-spring-boot-app.jar"]
