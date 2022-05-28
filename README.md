# Axon-Spring Module Error 

This repo is an attempt to replicate an error in starting up an Axon-Spring Boot app which uses Java modules. 

## Commits

There are a number of commits which illustrate the problem:

- Commit ddb5b: No modules - app is working
- Commit 49c9f: Modules present - offending code commented out - app is working
- Commit c55c6: Offending code added - app throws exception on startup
 
The error is caused by the `@QueryHandler` method in `io.github.vab2048.axon.example_bug.app.query.account.AccountViewProjection`.

And the exception is:

> Caused by: java.lang.IllegalAccessError: superinterface check failed: class io.github.vab2048.axon.example_bug.app.query.account.AccountViewProjection$$EnhancerBySpringCGLIB$$ca1d3464 (in module io.github.vab2048.axon.example_bug.app) cannot access class org.springframework.aop.framework.Advised (in unnamed module @0x4416d64f) because module io.github.vab2048.axon.example_bug.app does not read unnamed module @0x4416d64f

Even though the package is exported and open in the `module-info.java`


## Replicate the error/Usage

1. Checkout the correct commit.
2. Have a local postgres DB running and set up.
   - The DB should be called "axon-app" (see src/resources/db) 
3. Change the `application.properties` datasource properties with the correct postgres DB details.
   - The current settings should work. 
4. Change the `build.gradle` flyway closure with the correct postgres DB details.
    - The current settings should work. 
5. Run `./gradlew flywayClean` && `./gradlew flywayMigrate` to get the DB schema in place.
6. Run Axon Server.
7. Run the application using `./gradlew bootRun` or using the autogenerated Spring Boot run configuration (if using IntelliJ).
8. If replicating the error:
   - Observe how app does not startup and fails.
9. Or if running working app:
   - Check `localhost:8080/swagger-ui.html` for the swagger UI and play around with the app.