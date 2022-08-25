FROM maven:3.6.1-jdk-8-alpine AS MAVEN_BUILD
COPY ./ ./
# package our application code

RUN mvn clean package

FROM openjdk:8-jre-alpine3.9
COPY --from=MAVEN_BUILD target/rectangle-algo-1.0-SNAPSHOT.jar /rectangle-algo.jar

# set the startup command to execute the jar
CMD ["java", "-jar", "/rectangle-algo.jar"]
