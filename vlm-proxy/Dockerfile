FROM eclipse-temurin:17-jdk-alpine
COPY target/*.jar vlm-proxy.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/vlm-proxy.jar"]