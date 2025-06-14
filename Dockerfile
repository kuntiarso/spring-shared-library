# run stage
FROM eclipse-temurin:21-jdk-jammy
LABEL maintainer="gilang.grk17@gmail.com"
WORKDIR /app

# copy the built JAR from the build stage
COPY /target/*.jar shared-library.jar

# run the application
EXPOSE 8080
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0"
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar shared-library.jar"]