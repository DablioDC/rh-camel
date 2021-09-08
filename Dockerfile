FROM openjdk:8-jdk-slim
RUN apt-get update && apt-get install -y wget
ADD target/*.jar /opt/app/app.jar
ENV JAVA_OPTS="-Xmx128m"
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS  -jar /opt/app/app.jar"]