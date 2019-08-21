FROM openjdk:8
ADD target/fe.war fe.war
EXPOSE 80
ENTRYPOINT ["java", "-jar", "fe.war"]