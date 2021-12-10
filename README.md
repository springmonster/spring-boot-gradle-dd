# How to load external jar in Spring Boot
1. Add dependency
> Don't depend on mysql-connector-java
```
    dependencies {
    implementation 'org.springframework.boot:spring-boot-starter'
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'org.springframework.boot:spring-boot-starter-jdbc'
//    implementation 'mysql:mysql-connector-java:8.0.27'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
}
```
2. Modify `bootJar`
```
bootJar {
    manifest {
        attributes 'Main-Class': 'org.springframework.boot.loader.PropertiesLauncher'
    }
}
```
3. Start application
```
java -Dloader.path=/Users/kuanghaochuan/Projects/java-test/as/spring-boot-gradle-dd/test/mysql-connector-java-8.0.27.jar -jar /Users/kuanghaochuan/Projects/java-test/as/spring-boot-gradle-dd/test/spring-boot-gradle-dd-0.0.1-SNAPSHOT.jar
```