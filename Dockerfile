FROM openjdk:15-alpine

RUN apk add curl jq

# Directory
WORKDIR /viacomcbs/web

# ADD .jar  into this images
ADD web/target/aquaweb.jar aquaweb.jar
ADD web/target/aquaweb-tests.jar aquaweb-tests.jar
ADD web/target/libs libs

ADD healthcheck.sh                      healthcheck.sh

ADD web/src/test/resources/testng.xml     testng.xml

ENTRYPOINT sh healthcheck.sh