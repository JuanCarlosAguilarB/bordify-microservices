# Makefile for running the microservices of the project


run-auth-server:
	#./auth-server/gradlew :auth-server:bootRun
	cd auth-server  && ./gradlew bootRun


