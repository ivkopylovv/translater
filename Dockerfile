FROM gradle:jdk11 as build

ENV APP_HOME=/usr/app/

WORKDIR $APP_HOME
COPY build.gradle settings.gradle $APP_HOME
COPY --chown=gradle:gradle . /home/gradle/src
USER root
RUN chown -R gradle /home/gradle/src
RUN gradle build || return 0
COPY . .
RUN gradle clean build

FROM openjdk:17-alpine
ENV ARTIFACT_NAME=translator-0.0.1-SNAPSHOT.jar
ENV APP_HOME=/usr/app/

WORKDIR $APP_HOME
COPY --from=build $APP_HOME/build/libs/$ARTIFACT_NAME .

EXPOSE 8081
ENTRYPOINT exec java -jar ${ARTIFACT_NAME}