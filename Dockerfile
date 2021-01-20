FROM bellsoft/liberica-openjdk-alpine:11.0.9-12
WORKDIR /
COPY target/bomber-base-0.1.0-SNAPSHOT.jar bomber-base-0.1.0-SNAPSHOT.jar
COPY config/application.properties config/application.properties
EXPOSE 2222
CMD java -jar bomber-base-0.1.0-SNAPSHOT.jar --spring.config.location=config/application.properties