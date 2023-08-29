#Build Stage
FROM atlassian/maven:latest as build
COPY . .
RUN mvn clean package -X
#Package
FROM eclipse-temurin
COPY --from=build target/MyAssist-0.0.1-SNAPSHOT.jar /opt/MyAssist.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/opt/MyAssist.jar"]
