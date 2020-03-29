FROM openjdk:8

COPY target/backend-simple-api.jar app.jar
COPY src/main/resources .

ENTRYPOINT ["java","-cp", "resources/movies.json", "-jar", "app.jar"]