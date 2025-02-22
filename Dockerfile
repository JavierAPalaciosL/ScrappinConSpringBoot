# Fase de construcción (build stage)
FROM maven:3.8.6-openjdk-17 AS builder
WORKDIR /app
COPY pom.xml ./
COPY src ./src
# Construye el JAR y omite tests (opcional)
RUN mvn clean package -DskipTests

# Fase de ejecución
FROM amazoncorretto:17.0.14
WORKDIR /
# Copia el JAR desde la fase de construcción
COPY --from=builder /app/target/*.jar /app.jar
CMD ["java", "-jar", "app.jar"]