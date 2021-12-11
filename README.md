# How to load external jar in Spring Boot and how to implement in Docker
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
4. Copy spring-boot-gradle-dd.jar to docker folder
5. Copy mysql-connector-java.jar to lib folder
6. Go to docker folder, execute docker build command
```
docker build . --tag khc:spring-boot-gradle-dd
```
7. Go to lib folder, execute docker run build
```
docker run -it -v ${PWD}:/opt 143a9a3f03c8 /bin/bash
```
8. In docker container, run java -jar command
```
root@3d954e5a12b5:/app# java -Dloader.path=/opt/* -jar spring-boot-gradle-dd-0.0.1-SNAPSHOT.jar 
```