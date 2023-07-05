.PHONY : build test start run


build:
	mvn clean package

test:
	mvn test

start: build run

run:
	java -jar ./target/testing-practice-*.jar
