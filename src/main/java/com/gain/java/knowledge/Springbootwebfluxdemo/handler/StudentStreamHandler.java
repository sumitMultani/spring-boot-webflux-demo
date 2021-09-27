package com.gain.java.knowledge.Springbootwebfluxdemo.handler;

import java.time.Duration;

import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.gain.java.knowledge.Springbootwebfluxdemo.model.Student;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentStreamHandler {

	
	public Mono<ServerResponse> getAllStudents(ServerRequest request){
		Flux<Student> students = Flux.range(1, 20)
				.delayElements(Duration.ofSeconds(1))
				.doOnNext(i -> System.out.println("Student Record : " + i))
				.map(i -> new Student(i, "student " + i));

		return ServerResponse.ok()
				.contentType(MediaType.TEXT_EVENT_STREAM)
				.body(students, Student.class);
	}
}
