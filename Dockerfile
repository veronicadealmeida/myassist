#Build Stage
FROM ringcentral/maven:3.8.2-jdk20 as build
COPY . .
RUN mvn clean package -X
#Package
FROM eclipse-temurin:20-jdk-alpine
COPY --from=build target/MyAssist-0.0.1-SNAPSHOT.jar /opt/MyAssist.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/opt/MyAssist.jar"]
