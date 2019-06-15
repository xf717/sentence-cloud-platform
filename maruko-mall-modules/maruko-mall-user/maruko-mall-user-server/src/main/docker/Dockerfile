FROM livingobjects/jre8
VOLUME /tmp
ADD maruko-mall-user-server.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
