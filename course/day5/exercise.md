# Learn how to implement a simple application that expose REST services using SpringBoot and SpringMVC

Download [backend-course_day5.zip](backend-course_day5.zip) file and import into your IDE as maven project.

the structure of the project is 
```txt
├── pom.xml
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── mcs
    │   │           └── be
    │   │               └── course
    │   │                   ├── BackendCourseApplication.java
    │   │                   ├── aspect
    │   │                   │   └── DebuggingLoggingAspect.java
    │   │                   ├── config
    │   │                   │   ├── MvcConfig.java
    │   │                   │   └── SwaggerConfig.java
    │   │                   ├── controller
    │   │                   │   └── rest
    │   │                   │       └── RestArticleController.java
    │   │                   ├── dao
    │   │                   │   └── ArticleDao.java
    │   │                   ├── dto
    │   │                   │   ├── ApiError.java
    │   │                   │   └── ArticleDto.java
    │   │                   ├── exception
    │   │                   │   └── ElementNotFound.java
    │   │                   ├── facade
    │   │                   │   ├── ArticleFacade.java
    │   │                   │   └── impl
    │   │                   │       └── ArticleFacadeImpl.java
    │   │                   ├── handler
    │   │                   │   └── RestResponseEntityExceptionHandler.java
    │   │                   ├── mapping
    │   │                   │   └── ArticleMapping.java
    │   │                   ├── model
    │   │                   │   └── Article.java
    │   │                   └── service
    │   │                       ├── ArticleService.java
    │   │                       └── impl
    │   │                           └── ArticleServiceImpl.java
    │   ├── resources
    │   │   ├── application.properties
    │   │   ├── data-h2.sql
    │   │   ├── log4j2.yaml
    │   │   ├── static
    │   │   └── templates
    │   └── webapp
    │       └── WEB-INF
    └── test
        ├── java
        └── resources

```

The project is based on Spring Boot and has a configuration that enable the use of an embedded tomcat, so you can run the project using your IDE.
The project uses an embedded database in memory (http://www.h2database.com/html/main.html). 
If you want to perform some queries or see content of DB you can reach that at http://localhost:8080/h2-console/
the credentials to reach it are inside `application.properties` in resources project folder.

To run the application launch as a main method inside `BackendCourseApplication.java` class. 

To test your services create a new collections and requests inside Postman.

GOAL: Implement everything necessary to expose these REST service:'
- `/articles` HTTP method `GET` 
- `/articles/:id/` HTTP method `GET` 
- `/articles/:id/` HTTP method `PATCH` message body `{"like" : true}` 

HINT:
- Check TODO inside `RestArticleController.java` and `ArticleMapping.java`
- use the slide on Rest Controller Example as an help
- remember to add `Content-Type application/json` header as well as body inside postman PATCH request
- to add param in postman request use :param inside url path and click on Params button to add key values


After implementation when everything works try to reach this URL and check if the auto-documentation is working: http://localhost:8080/swagger-ui.html


Additional:
- add an handle method inside `RestResponseEntityExceptionHandler.java` to handle the response in case of `ElementNotFound`exception with a 200 HttpStatus and a custom message. 
- `/articles/search?by=:searchBy&eq=:searchValue` HTTP method `GET`. 
- '/articles that add a new article passed as request parameter
- open the class `DebuggingLoggingAspect.java` that is already annotated as Aspect Component and add a new method with a joint point to log method call and method response time.
```
HINT for Additional
1) Use the other method inside the RestResponseEntityExceptionHandler as an example.
2-3) Follow the layer structure implementing a new method on controller, facade, dervice, dao.
3) Use an around joint point with execution regular expression on package to match all pointcuts. 
   Use string interpolation inside LOGGER.debug("...") eg.  LOGGER.debug("blabla {} bla {} bla",arg0,arg1);
   Use System.currentTimeMillis() to get milliseconds
   Remember to use the proceed() method on joint point to execute method
   If you need helps at this link you can find an example solution http://www.springboottutorial.com/spring-boot-and-aop-with-spring-boot-starter-aop.

```

You can use all libraries you want to help in your development adding them to maven dependencies. 

Solution: [backend-course_day5_examplesolution.zip](backend-backend-course_day5_examplesolution.zip).

