package com.shardul.student.dal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shardul.student.dal.entities.Student;
import com.shardul.student.dal.repos.StudentRepository;

@SpringBootTest
class StudentdalApplicationTests {

	@Autowired
	private StudentRepository repo;

	@Test
	void testCreateStudent() {
		Student student = new Student();
		student.setName("Frank");
		student.setCourse("JavaScript");
		student.setFee(20d);
		repo.save(student);
	}

	@Test
	void testFindStudentById() {
		Student student = repo.findById(1l).get();
		System.out.println(student);
	}

	@Test
	void testUpdateStudent() {
		Student student = repo.findById(1l).get();
		student.setFee(40d);
		repo.save(student);
		System.out.println(student + " updated");

	}

	@Test
	void testDeleteStudent() {
		Student student = repo.findById(2l).get();
		repo.delete(student);
		System.out.println(student + " deleted");
	}

}
