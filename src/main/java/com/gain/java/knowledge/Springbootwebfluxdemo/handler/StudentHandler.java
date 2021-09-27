package com.gain.java.knowledge.Springbootwebfluxdemo.handler;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.gain.java.knowledge.Springbootwebfluxdemo.model.Student;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentHandler {

	public Mono<ServerResponse> getAllStudent(ServerRequest request) {
		Flux<Student> students = Flux.range(1, 20).doOnNext(i -> System.out.println("Student Record : " + i))
				.map(i -> new Student(i, "student " + i));

		return ServerResponse.ok().body(students, Student.class);
	}
	
	public Mono<ServerResponse> findById(ServerRequest request){
		String pathVariable = request.pathVariable("student_id");
		Integer studentId = Integer.valueOf(pathVariable);
		Flux<Student> students = Flux.range(1, 20).doOnNext(i -> System.out.println("Student Record : " + i))
				.map(i -> new Student(i, "student " + i));
		Mono<Student> next = students.filter(std -> std.getId() == studentId).next();
		return ServerResponse.ok().body(next, Student.class);
	}
	
	public Mono<ServerResponse> addStudent(ServerRequest request){
		Mono<Student> bodyToMono = request.bodyToMono(Student.class);
		Mono<String> student = bodyToMono.map(std -> std.getId() + " : "+ std.getName());
		return ServerResponse.ok().body(student, String.class);
	}
	
	
}
