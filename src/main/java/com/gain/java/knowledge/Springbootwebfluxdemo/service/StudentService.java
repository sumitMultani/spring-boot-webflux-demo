package com.gain.java.knowledge.Springbootwebfluxdemo.service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gain.java.knowledge.Springbootwebfluxdemo.model.Student;

import reactor.core.publisher.Flux;

@Service
public class StudentService {

	public List<Student> getStudents() {
		Long start = System.currentTimeMillis();

		List<Student> studentList = new ArrayList<Student>();
		for (int i = 1; i <= 20; i++) {
			studentList.add(new Student(i, "student " + i));
			System.out.println("Student Record : " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Long end = System.currentTimeMillis();
		System.out.println("Total time taken By API : " + (end - start));
		return studentList;
	}

	public Flux<Student> getStudentList() {
		Long start = System.currentTimeMillis();
		Flux<Student> studentList = Flux.range(1, 20).delayElements(Duration.ofSeconds(1))
				.doOnNext(i -> System.out.println("Student Record By Stream : " + i))
				.map(i -> new Student(i, "student " + i));
		Long end = System.currentTimeMillis();
		System.out.println("Total time taken By API : " + (end - start));
		return studentList;
	}

}
