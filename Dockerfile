FROM openjdk:8-jre-alpine
EXPOSE 8080
WORKDIR /app
COPY target/credit-score-1.0-SNAPSHOT.jar .
ENTRYPOINT [ "java", "-jar", "credit-score-1.0-SNAPSHOT.jar" ]