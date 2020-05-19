FROM alpine AS build

ARG COMMIT_SHA=<not-specified>
ARG BUILD_FILE_NAME=%CUSTOM_PLUGIN_SERVICE_NAME%

WORKDIR /build

COPY ./target/${BUILD_FILE_NAME}.jar ./application.jar
COPY LICENSE .

RUN echo "service-name: $COMMIT_SHA" >> ./commit.sha

FROM openjdk:8-jre-slim

LABEL maintainer="%CUSTOM_PLUGIN_CREATOR_USERNAME%" \
      name="%CUSTOM_PLUGIN_SERVICE_NAME%" \
      description="%CUSTOM_PLUGIN_SERVICE_DESCRIPTION%" \
      eu.mia-platform.url="https://www.mia-platform.eu" \
      eu.mia-platform.version="0.1.0"

# set deployment directory
WORKDIR /home/java/app

COPY --from=build /build .

USER 1000

CMD ["java", "-jar", "./application.jar"]
