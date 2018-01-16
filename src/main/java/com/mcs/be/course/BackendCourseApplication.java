package com.mcs.be.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class BackendCourseApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BackendCourseApplication.class, args);
	}
}
