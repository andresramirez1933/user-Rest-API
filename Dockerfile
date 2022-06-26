#Start with a base image containing Java runtime
#Command to install Java inside your docker
FROM openjdk:8-slim as build

#Information around who maintains the image
MAINTAINER Andres Ramirez

#Add the application's jar to the container
COPY target/user-0.0.1-SNAPSHOT.jar user-0.0.1-SNAPSHOT.jar

#Execute the application
ENTRYPOINT ["java", "-jar","user-0.0.1-SNAPSHOT.jar"]
