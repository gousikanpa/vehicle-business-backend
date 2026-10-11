
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app
COPY .mvn/ .mvn/
COPY mvnw pom.xml ./
RUN chmod +x mvnw
RUN ./mvnw -B dependency:go-offline


RUN mkdir -p src/main/resources
RUN printf '%s\n' \
  'spring.datasource.url=${DB_URL}' \
  'spring.datasource.username=${DB_USERNAME}' \
  'spring.datasource.password=${DB_PASSWORD}' \
  'spring.jpa.hibernate.ddl-auto=update' \
  'spring.jpa.show-sql=false' \
  'spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect' \
  > src/main/resources/application.properties

COPY src ./src
RUN ./mvnw -B clean package -DskipTests

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 10000

ENTRYPOINT ["sh", "-c", "java -Dserver.port=${PORT:-10000} -jar app.jar"]

