FROM openjdk:17-jdk-slim
COPY target/ic-partner-sender-1.0-SNAPSHOT.jar /home/ic-partner-sender.jar
ENTRYPOINT java -jar /home/ic-partner-sender.jar