From openjdk:11
copy ./target/stock-exchange-service-1.0.jar stock-exchange-service-1.0.jar
CMD ["java","-jar","stock-exchange-service-1.0.jar"]