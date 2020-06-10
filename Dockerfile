FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} bookstore.jar
ENV JAVA_OPTS_MEMORY='-Xms1024m -Xmx8192m'
ENTRYPOINT ["java","-jar","/bookstore.jar"]