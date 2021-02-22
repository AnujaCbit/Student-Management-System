# Multi Module Project

[![Build Status](https://travis-ci.org/codecentric/springboot-sample-app.svg?branch=master)](https://travis-ci.org/codecentric/springboot-sample-app)
[![Coverage Status](https://coveralls.io/repos/github/codecentric/springboot-sample-app/badge.svg?branch=master)](https://coveralls.io/github/codecentric/springboot-sample-app?branch=master)
[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)


## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)
- mysql

## Running the application locally

There are several ways to run this application on your local machine. One way is build the core library and execute the `main` method in the `Application` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
cd core
mvn clean install
mvn spring-boot:run
```
## Used Technologies
* Spring Boot
* Spring Data JPA
* Maven
* MySql
* Lombok

## Copyright

Released under the Apache License 2.0. See the [LICENSE](https://github.com/codecentric/springboot-sample-app/blob/master/LICENSE) file.
