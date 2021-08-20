package com.school.dao;

import java.util.List;

import com.school.bean.School;

public interface SchoolDao {

	School addSchoolName(School model);

	List<School> getAll();

	School getByUsernameAndPassword(String schoolName, String schoolPlace);
	
	School getOneSchoolName(String id);
	
	School update(School school);

	void deleteById(String id);

}
