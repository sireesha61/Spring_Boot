package com.school.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.school.bean.Student;

public interface StudentRepository extends MongoRepository<Student, String> {

	Student findByStdUsernameAndStdPassword(String stdUsername, String stdPassword);
}
