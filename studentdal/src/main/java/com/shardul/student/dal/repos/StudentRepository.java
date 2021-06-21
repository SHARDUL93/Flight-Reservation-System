package com.shardul.student.dal.repos;

import org.springframework.data.repository.CrudRepository;

import com.shardul.student.dal.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
