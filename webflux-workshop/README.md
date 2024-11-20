# Spring Webflux Workshop
This is a simplified library application from the earlier workshop.  
It is you task to migrate it to Spring Webflux.

We are doing this in smaller steps.

## 1. Migration

### 1.1 Migrate RestController
The first step is to migrate the RestController only.  
Migrate the `LibraryController` to return only Mono and Flux.

Change Dependency
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```
to
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-webflux</artifactId>
</dependency>
```

<details>
<summary>Hint</summary>

Use `Mono.just()` and `Flux.fromIterable()`. 
</details>

### 1.2 Migrate Services
We now move the border a little and migrate the Services only.  

<details>
<summary>Hint</summary>

The Mono and Flux calls should not start in the controller anymore, but right after the database call.
</details>

### 1.3 Migrate Database
We are now migrating the rest of the application. This is a bigger step.

- Change Dependency
    ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    ```
    to
    ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-r2dbc</artifactId>
    </dependency>
    ```
- add Dependency
    ```xml
    <dependency>
        <groupId>io.r2dbc</groupId>
        <artifactId>r2dbc-h2</artifactId>
        <scope>runtime</scope>
    </dependency>
    ```
- change `jdbc` in properties to `r2dbc` 
- change `url` in properties to `r2dbc:h2:mem:///mydb`
- make the repositories extend `ReactiveCrudRepository`
- return only Mono and Flux in the repositories

## 2. Additional tasks: Development

### 2.1 new feature: validity checks
Fix the following:
- it is currently possible to rent a book which is already rented 
- it is currently possible to return a book which is not rented

### 2.2 new feature: all available books
write an endpoint which lists all available books

### 2.3 new feature: all books for a customer
write an endpoint which lists all books for a customer
