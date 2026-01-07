# ===== STAGE 1: build com Maven =====
FROM maven:3.9.9-eclipse-temurin-21 AS builder

WORKDIR /build

# copia os arquivos de configuração primeiro (melhora cache)
COPY pom.xml .
COPY src ./src

# faz o build
RUN mvn clean package -DskipTests


# ===== STAGE 2: runtime =====
FROM eclipse-temurin:21-jre

WORKDIR /app

# copia o jar gerado no stage anterior
COPY --from=builder /build/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]



