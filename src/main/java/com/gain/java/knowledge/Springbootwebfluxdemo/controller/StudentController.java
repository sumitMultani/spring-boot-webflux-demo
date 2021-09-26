package com.gain.java.knowledge.Springbootwebfluxdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gain.java.knowledge.Springbootwebfluxdemo.model.Student;
import com.gain.java.knowledge.Springbootwebfluxdemo.service.StudentService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService service;
	
	@GetMapping("/")
	public List<Student> student(){
		return service.getStudents();
	}
	
	@GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Student> studentList(){
		return service.getStudentList();
	}
	
}
