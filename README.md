# blog-environments-with-spring-profiles
this project shows how to use spring profiles for different environments and configurations.

## Technologies / Frameworks
 - Java 1.8
 - Spring Boot Web Application (embedded tomcat)
 - Lombok  
 Install the `lombok` plugin and activate `Enable annotation processing` (IDEA Preferences).

## Dependencies
no external dependencies

## Deployment
use the jvm parameter `-Dspring.profiles.active` to configure the environment.

### Spring Profiles

##### there are two general environment profiles:
 - `test`  
 configures logback to use file logging.
 - `prod`  
 configures logback to use file logging.

##### Example config
- server dude  
`-Dspring.profiles.active=prod,dude`
