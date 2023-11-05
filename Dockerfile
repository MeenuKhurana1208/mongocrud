FROM openjdk:21
VOLUME /tmp
ARG JAR_FILE=target/mongocrud-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} mongocrud.jar
ENTRYPOINT ["java","-jar","/mongocrud.jar"]