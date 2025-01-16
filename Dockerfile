FROM eclipse-temurin:21-jdk
WORKDIR /app

COPY target/vet-0.0.1-SNAPSHOT.jar /app/vet-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD  ["java", "-jar", "/app/vet-0.0.1-SNAPSHOT.jar"]
