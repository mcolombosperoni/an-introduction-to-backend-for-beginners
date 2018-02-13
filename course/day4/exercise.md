# Learn how to implement a simple web application using JEE features

Download [backend-course_day4.zip](backend-course_day4.zip) file and import into your IDE as maven project.

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
    │   │                   ├── BackendCourseDay4Application.java
    │   │                   ├── config
    │   │                   │   └── MvcConfig.java
    │   │                   ├── controllers
    │   │                   └── services
    │   │                       ├── InventoryService.java
    │   │                       ├── InventoryServiceImpl.java
    │   │                       └── Product.java
    │   ├── resources
    │   │   ├── application.properties
    │   │   ├── static
    │   │   └── templates
    │   └── webapp
    │       └── WEB-INF
    │           ├── tags
    │           │   └── mainLayout.tag
    │           └── view
    │               ├── productDetail.jsp
    │               └── productList.jsp
    └── test
        └── java
            └── com
                └── mcs
                    └── be
                        └── course
                            └── BackendCourseDay4ApplicationTests.java

```

The project is based on Spring Boot and has a configuration that enable the use of an embedded tomcat, so you can run the project using your IDE.
To run the application launch as a main method inside `BackendCourseDay4Application` class. 


GOAL: Implement everything necessary to see a product list and a product detail page as you did in the last lecture.

HINT:
- check how it is configured the view resolver inside `MvcConfig` class
- check how are defined the urls inside JSPs
- create a Controller class as a Spring MVC controller
- add two request mapping methods, one for the list and one for the detail inside the Controller.
- inject the InventoryService as a dependency inside the controller
- implement the two methods above with the right logic to call the right view


You can use all libraries you want to help in your development adding them to maven dependencies. 

