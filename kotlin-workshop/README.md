# Kotlin Workshop
In this workshop we want to migrate the application to Kotlin

## Tasks

### 1. Examples

#### 1.2 Kotlin
Go through the Java examples in the `kotlin-examples` module and solve them to get used to the language.


### 2. Enabling Kotlin
Add the following dependencies to the pom.xml of your library application
```xml
<dependency>
    <groupId>com.fasterxml.jackson.module</groupId>
    <artifactId>jackson-module-kotlin</artifactId>
</dependency>
<dependency>
    <groupId>org.jetbrains.kotlin</groupId>
    <artifactId>kotlin-reflect</artifactId>
</dependency>
<dependency>
    <groupId>org.jetbrains.kotlin</groupId>
    <artifactId>kotlin-stdlib</artifactId>
</dependency>

<dependency>
<groupId>org.jetbrains.kotlin</groupId>
<artifactId>kotlin-test-junit5</artifactId>
<scope>test</scope>
</dependency>
```

replace the build part with the following
```xml
<build>
    <sourceDirectory>${project.basedir}/src/main/java</sourceDirectory>
    <testSourceDirectory>${project.basedir}/src/test/java</testSourceDirectory>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
        <plugin>
            <groupId>org.jetbrains.kotlin</groupId>
            <artifactId>kotlin-maven-plugin</artifactId>
            <configuration>
                <args>
                    <arg>-Xjsr305=strict</arg>
                </args>
                <compilerPlugins>
                    <plugin>spring</plugin>
                    <plugin>jpa</plugin>
                </compilerPlugins>
                <pluginOptions>
                    <option>all-open:annotation=jakarta.persistence.Entity</option>
                    <option>all-open:annotation=jakarta.persistence.MappedSuperclass</option>
                    <option>all-open:annotation=jakarta.persistence.Embeddable</option>
                </pluginOptions>
            </configuration>
            <dependencies>
                <dependency>
                    <groupId>org.jetbrains.kotlin</groupId>
                    <artifactId>kotlin-maven-allopen</artifactId>
                    <version>${kotlin.version}</version>
                </dependency>
                <dependency>
                    <groupId>org.jetbrains.kotlin</groupId>
                    <artifactId>kotlin-maven-noarg</artifactId>
                    <version>${kotlin.version}</version>
                </dependency>
            </dependencies>
        </plugin>
    </plugins>
</build>
```
Now your Spring application can use Kotlin and Java classes together.

### 3. Kotlin Migration
Migrate at least:
- 2 models
- 2 repositories
- 2 Dtos
- 1 Service
- the tests

You may use the automatic conversion, but it still needs a lot of adjustments to get it right.

<details>
<summary>Hint</summary>

- you might run into a lot of nullability issues, use `?`, `?.`, `?:` and `!!` accordingly
- the `@NotEmpty` annotation becomes `@field:NotEmpty`  
- when using field injection with `@MockBean` or `@Autowired`, variable needs to be declared as `lateinit`
- the `List` interface in Kotlin is by default immutable, use `MutableList` in case you want to change it
</details>

### 4. Additional tasks
convert the whole repository