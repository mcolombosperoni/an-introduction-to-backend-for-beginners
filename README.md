An introduction to Backend for beginners 
=========================================

[![Build Status](https://travis-ci.org/mcolombosperoni/an-introduction-to-backend-for-beginners.svg?branch=master)](https://travis-ci.org/mcolombosperoni/an-introduction-to-backend-for-beginners)

Welcome to **An introduction to Backend for beginners**.

This project is intended as a result of an introduction course designed for beginner developers on how to build a simple backend application using spring boot and java.
The application has its own frontend based on spring MVC but exposes some REST services to other applications that might want to integrate.

This application is only a part of an entire solution made to perform a Fullstack course splitted in three modules: backend, [frontend](https://marcomontalbano.github.io/an-introduction-to-frontend-for-beginners), react.

If you want to test the application you can clone the repository and run it using the following command:

Prerequisites:
Apache Maven >= 3.3.9 
Java >= 1.8

```bash

mvn clean package
mvn spring-boot:run

```

The homepage is reachable at: 
- http://localhost:8080/ --> redirect to (JSP Version)
- (JSP Version) http://localhost:8080/webmvc/jsp
- (Thymeleaf Version) http://localhost:8080/webmvc/thymeleaf

The rest services are reacheable via POSTMAN at: 
```bash
GET http://localhost:8080/api/v1/articles
GET http://localhost:8080/api/v1/articles/1
PATCH http://localhost:8080/api/v1/articles/1  eg body. {"like" : true}  HEADER `Content-Type application/json`
```


### Course structure

Day 1 - EE Architecture and Tools: 
- [Slide Day 1](course/day1/backend_course_day1.pdf)
- [Installation guide](course/day1/InstallTools.md)
- [Exercise](course/day1/exercise.md)

Day 2 - Java SE: 
- [Slide Day 2](course/day2/backend_course_day2.pdf)
- [Exercise](course/day2/exercise.md)

Day 3 - Java EE: 
- [Slide Day 3](course/day3/backend_course_day3.pdf)
- [Exercise](course/day3/exercise.md)
    
Day 4 - Spring MVC: 
- [Slide Day 4](course/day4/backend_course_day4.pdf)
- [Exercise](course/day4/exercise.md)

Day 5 - Spring MVC: 
- [Slide Day 5](course/day5/backend_course_day5.pdf)
- [Exercise](course/day5/exercise.md)

Day 6 - Create a SpringBoot webapp from scratch:
- [Exercise](course/day6)

Day 7 - Integrating FE and BE:
- [Slide Day 7](course/day7/backend_course_day7.pdf)
- [Exercise](course/day7)