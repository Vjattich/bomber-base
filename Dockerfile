FROM maven:latest
ENV HOME=/usr/src/bomber-base
RUN mkdir -p $HOME
WORKDIR $HOME
ADD pom.xml $HOME
RUN ["mvn", "verify", "clean", "--fail-never"]
ADD . $HOME
RUN ["mvn", "package"]
CMD ["mvn", "spring-boot:run"]