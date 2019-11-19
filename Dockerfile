FROM alpine:3.10.3
MAINTAINER ThomasKuh <t@kuhlins.org>

RUN apk add --update openjdk11-jre-headless && rm -rf /var/cache/apk/*

ADD target/app.jar /app.jar
RUN mkdir data

VOLUME /data

EXPOSE 8080

ENTRYPOINT java $JOPTS -Ddir=/data -jar /app.jar
