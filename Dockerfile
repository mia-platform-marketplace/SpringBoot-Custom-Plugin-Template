FROM maven:3.6.3-jdk-8 as build

ARG COMMIT_SHA=<not-specified>

# copy the project files
COPY ./pom.xml ./pom.xml

COPY ./LICENSE ./LICENSE

# build all dependencies for offline use
RUN mvn dependency:go-offline -B

# copy your other files
COPY ./src ./src

# build for release
RUN mvn package

RUN echo "service-name: $COMMIT_SHA" >> ./commit.sha

###############################################################################

# our final base image
FROM openjdk:8u171-jre-alpine

# set deployment directory
WORKDIR /usr/app

# copy over the built artifact from the maven image
COPY --from=build ./target/%CUSTOM_PLUGIN_SERVICE_NAME%-0.0.1-SNAPSHOT.jar ./

COPY --from=build ./commit.sha ./commit.sha

COPY --from=build ./LICENSE ./LICENSE

CMD ["java","-jar","./%CUSTOM_PLUGIN_SERVICE_NAME%-0.0.1-SNAPSHOT.jar"]