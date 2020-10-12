FROM openjdk:11
ADD target/action-app.jar action-app.jar
EXPOSE 8091
ENTRYPOINT ["java", "-jar", "action-app.jar"]
