FROM java:8-jdk-alpine
ADD ./build/libs/springreactive-poc-1.0.0.jar springreactive-poc-1.0.0.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/springreactive-poc-1.0.0.jar"]