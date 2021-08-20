package com.school.dao;

import java.util.List;

import com.school.bean.Student;

public interface StudentDao {

	Student addStudent(Student bean);

	List<Student> getAll();

	void deleteById(String id);

	Student getByUsernameAndPassword(String stdUsername, String stdPassword);

	Student getOneStudent(String id);

	Student update(Student student);
}
