FROM openjdk:17-jdk
#RUN apt-get update && apt-get install sudo
# 포트 기본
EXPOSE 8080
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
LABEL authors="seungho"
ENTRYPOINT ["java", "-jar", "/app.jar"]

#꼭 따로 공부해보는 것이 필요