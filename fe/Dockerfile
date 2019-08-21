FROM openjdk:8
ADD target/fe.jar fe.jar
EXPOSE 80
ENTRYPOINT ["java", "-jar", "fe.jar"]