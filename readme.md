# Migration from Monolith to Microservices: Bordify Project

## Description
This project aims to migrate the monolithic Bordify application, designed to manage tasks and projects in the style of Trello, to a microservices architecture. The migration will be done progressively, maintaining the functionality of the monolith in conjunction with the newly implemented microservices. Currently, the user-server, auth-server, api-gateway and discovery-server microservices have been developed and implemented with Eureka Server.


## Project Structure
The repository contains the following relevant directories and files:

- bordify-monolith: Contains the implementation of the Bordify monolith.
- user-server: Microservice responsible for user management.
- auth-server: Microservice responsible for user authentication and authorization.
- api-gateway: API gateway that directs requests to the corresponding microservices.
- discovery-server: Eureka discovery server for dynamic service management.
- template-server: Directory for the implementation of future microservices.
- Makefile: Makefile for automating common tasks.
- readme.md: This README file provides information about the project.

## Benefits of Microservices in Migration
1) Gradual Decomposition:

   Microservices architecture allows a gradual migration from the monolith to a more modular structure. You can start by identifying specific areas of the application that can benefit from decomposition into independent services, which reduces risk and facilitates progressive adoption.

2) Simplified Maintenance:

    By breaking the application into smaller, more focused services, maintenance becomes more manageable. Teams can work on individual services without worrying about affecting other parts of the system, which reduces the risk of introducing bugs and speeds up development time.

3) Granular Scalability:

   With microservices, you can scale each service independently according to its load requirements. This means that resources can be allocated more efficiently, avoiding over-provisioning resources for application components that don't need them.

4) Specialized Technology and Tools:

   Each microservice can use the most appropriate technology and tools for its specific function. This allows the adoption of modern technologies and the flexibility to choose the best solution for each service, which can improve overall performance and efficiency.