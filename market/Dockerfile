FROM openjdk:11
MAINTAINER Gabriel Ferreira
WORKDIR /app
COPY target/app.war /app/app.war
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.war"]