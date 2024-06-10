run application with the following command:

```bash
./gradlew :bordify-monolith:bootRun
./gradlew :discovery-server:bootRun
./gradlew :api-gateway:bootRun
```

Eureka server:
http://localhost:8761/

## TODO:
## problem. is needle to use a strategy for migrate data between databes, for example, from auth-server to user-serve (events)