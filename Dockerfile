FROM openjdk:17
ADD target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]