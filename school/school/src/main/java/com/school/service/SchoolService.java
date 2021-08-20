package com.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.bean.BeanClass;
import com.school.bean.School;
import com.school.dao.SchoolDao;
import com.school.utils.TokenUtils;
@Service
public class SchoolService {
	@Autowired
	SchoolDao dao;
	
	@Autowired
	TokenUtils tu;
	public School addSchoolName(School model) {
			return dao.addSchoolName(model);
	}

	public List<School> getSchoolName() {
			return dao.getAll();
	}

	public void deleteById(String id) {
		dao.deleteById(id);
		
	}

	public BeanClass getToken(School bean) {
		School token = dao.getByUsernameAndPassword(bean.getSchoolName(),bean.getSchoolPlace());
		BeanClass jwt = new BeanClass();
			if(token==null) {
				jwt.setBean("Please signup first");
			}
			else {
				jwt.setBean(tu.getToken(token));
			}
		return jwt;
	}

	public School getOneSchoolName(String id) {
		return dao.getOneSchoolName(id);
	}

	public School update(School model, String id) {
		School school = dao.getOneSchoolName(id);
		if(school!=null) {
			if(school.getSchoolName()!=null && model.getSchoolName()!=null) {
				school.setSchoolName(model.getSchoolName());
				}
			else if(school.getSchoolPlace()!=null && model.getSchoolPlace()!=null) {
				school.setSchoolPlace(model.getSchoolPlace());
			}
		}
		return dao.update(school);
	}
}