FROM openjdk:17-alpine
WORKDIR /spring
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ADD target/ /spring
ARG JAR_FILE=target/*.jar
CMD ["java", "-jar", "hospital-app.jar"]
EXPOSE 3443