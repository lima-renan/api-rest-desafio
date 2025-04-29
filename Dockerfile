# Etapa 1: Construção do JAR
FROM maven:3.9-eclipse-temurin-21 AS builder

# Definir o diretório de trabalho
WORKDIR /app

# Copiar o pom.xml e os arquivos de código fonte da pasta 'api' para o contêiner
COPY api/pom.xml .
COPY api/src ./src

# Rodar o maven para construir o JAR
RUN mvn clean install -DskipTests

# Etapa 2: Executar a aplicação
FROM openjdk:21-jdk-slim

# Definir o diretório de trabalho
WORKDIR /app

# Copiar o JAR gerado pela primeira etapa
COPY --from=builder /app/target/api-0.0.1-SNAPSHOT.jar app.jar

# Definir o comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
