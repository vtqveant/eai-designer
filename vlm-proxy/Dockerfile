FROM harbor.eventflow.ru/proxy-cache/eclipse-temurin:17-jdk-alpine
COPY target/*.jar vlm-proxy.jar
EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /vlm-proxy.jar"]