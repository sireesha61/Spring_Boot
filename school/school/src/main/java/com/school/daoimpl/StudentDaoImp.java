package com.school.daoimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.school.bean.Student;
import com.school.dao.StudentDao;
import com.school.repository.StudentRepository;

@Repository
public class StudentDaoImp implements StudentDao {
	@Autowired
	StudentRepository rpo;
	@Override
	public Student addStudent(Student bean) {	
		return rpo.save(bean);
	}
	@Override
	public List<Student> getAll() {	
		return (List<Student>) rpo.findAll();
	}
	@Override
	public void deleteById(String id) {
		rpo.deleteById(id);
	}
	@Override
	public Student getByUsernameAndPassword(String stdUsername, String stdPassword) {
		return rpo.findByStdUsernameAndStdPassword(stdUsername, stdPassword);
	}
	@Override
	public Student getOneStudent(String id) {
		return rpo.findById(id).orElseThrow();
	}
	@Override
	public Student update(Student student) {
		return rpo.save(student);
	}
}
