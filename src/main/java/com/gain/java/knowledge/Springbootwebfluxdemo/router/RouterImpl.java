package com.gain.java.knowledge.Springbootwebfluxdemo.router;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.gain.java.knowledge.Springbootwebfluxdemo.handler.StudentHandler;
import com.gain.java.knowledge.Springbootwebfluxdemo.handler.StudentStreamHandler;

@Configuration
public class RouterImpl {

	@Autowired
	private StudentHandler handler ;
	
	@Autowired
	private StudentStreamHandler streamHandler;
	
	 
	@Bean
	public RouterFunction<ServerResponse> routerFunctionA(){
		return RouterFunctions.route()
			.GET("/get/students", handler:: getAllStudent)
			.GET("/get/students/stream", streamHandler:: getAllStudents)
			.GET("/get/students/{student_id}", handler:: findById)
			.POST("/add/student", handler:: addStudent)
			.build();
	}
}
