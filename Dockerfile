#
# Build
#
FROM maven:3.9.3-eclipse-temurin-17-alpine as build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package
#
FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY --from=build home/app/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]