FROM localhost:5002/amazoncorretto:17-alpine
LABEL authors="ousseynou.mbodji"
COPY target/*.jar /opt/app/test-automation.jar
EXPOSE 7070
ENTRYPOINT ["java","-jar","/opt/app/devops-project-samples.jar"]