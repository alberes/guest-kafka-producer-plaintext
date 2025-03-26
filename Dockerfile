FROM maven:3.8.5-openjdk-17 as build

WORKDIR /build

COPY . .

RUN mvn clean package -DskipTests

FROM openjdk:17

WORKDIR /app

COPY --from=build ./build/target/*.jar ./guest-kafka-producer-plaintext.jar

EXPOSE 8081

ENTRYPOINT java -jar guest-kafka-producer-plaintext.jar