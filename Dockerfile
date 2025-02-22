FROM maven:3.8.7-openjdk-17 AS builder
WORKDIR /app
COPY pom.xml ./
COPY src ./src
RUN mvn clean package -DskipTests
FROM amazoncorretto:17.0.14
WORKDIR /
COPY --from=builder /app/target/*.jar /app.jar
CMD ["java", "-jar", "app.jar"]