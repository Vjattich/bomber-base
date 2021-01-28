FROM bellsoft/liberica-openjdk-alpine:11.0.9-12
ARG JAR_FILE=target/*.jar
ARG PROP_FILE=config/application.properties
COPY ${JAR_FILE} app.jar
COPY ${PROP_FILE} config/application.properties
ENTRYPOINT ["java","-jar","/app.jar"]