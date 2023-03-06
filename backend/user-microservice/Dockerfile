#Use the OpenJDK 17 image as the base image
FROM adoptopenjdk/openjdk17:alpine-slim

#set working directory
WORKDIR /app

#Copy Maven project files
COPY pom.xml .
COPY src/ ./src/

#Install Maven
RUN apk add --no-cache maven

#Build the project with maven
RUN mvn package

#Expose port
EXPOSE 8084

#Set the startup command to run spring boot app
CMD ["java","-jar","target/myapp.jar"]