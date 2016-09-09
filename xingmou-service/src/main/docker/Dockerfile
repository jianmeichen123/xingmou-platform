FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD xingmou-service-1.0-bt-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-jar","/app.jar"]