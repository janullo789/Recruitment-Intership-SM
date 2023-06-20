package com.example.todolistspringbootintership;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class TodoListSpringBootIntershipApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoListSpringBootIntershipApplication.class, args);
	}

}
