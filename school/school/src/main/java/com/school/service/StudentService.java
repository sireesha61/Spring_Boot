package com.school.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.school.bean.BeanClass;
import com.school.bean.Student;
import com.school.dao.StudentDao;
import com.school.utils.TokenUtils;
@Service
public class StudentService {
	@Autowired
	StudentDao dao;
	
	@Autowired
	TokenUtils tu;
	public Student addStudent(Student bean) {
		return dao.addStudent(bean);	
		}
	public List<Student> getStudent() {
		return dao.getAll();
	}
	public void deleteStudent(String id) {
		dao.deleteById(id);
	}
	public BeanClass getToken(Student bean) {
		Student token = dao.getByUsernameAndPassword(bean.getStdUsername(),bean.getStdPassword());
		BeanClass jwt = new BeanClass();
			if(token==null) {
				jwt.setBean("Please signup first");
			}
			else {
				jwt.setBean(tu.getToken(token));
			}
		return jwt;
	}
	public Student getOneStudent(String id) {
		return dao.getOneStudent(id);
	}
	public Student update(Student bean, String id) {
		Student student = dao.getOneStudent(id);
		if(student!=null) {
			if(student.getStdUsername()!=null && bean.getStdUsername()!=null) {
			student.setStdUsername(bean.getStdUsername());
			}
		else if(student.getStdPassword()!=null && bean.getStdPassword()!=null) {
			student.setStdPassword(bean.getStdPassword());
		}
		}
		return dao.update(student);
	}
}
