FROM openjdk:11.0.4-jre-slim

COPY EPM-configuration/build/libs/EPM-configuration-0.0.1-SNAPSHOT.jar EPM-configuration-0.0.1-SNAPSHOT.jar
COPY EPM-core/build/libs/EPM-core-1.0-SNAPSHOT.jar EPM-core-1.0-SNAPSHOT.jar
COPY adapters/EPM-persistence/build/libs/EPM-persistence-0.0.1-SNAPSHOT.jar EPM-persistence-0.0.1-SNAPSHOT.jar
COPY adapters/EPM-web/build/libs/EPM-web-0.0.1-SNAPSHOT.jar EPM-web-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/EPM-configuration-0.0.1-SNAPSHOT.jar"]