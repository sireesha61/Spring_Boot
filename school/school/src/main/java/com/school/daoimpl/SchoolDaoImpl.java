package com.school.daoimpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.school.bean.School;
import com.school.dao.SchoolDao;
import com.school.repository.SchoolRepository;
@Repository
public class SchoolDaoImpl implements SchoolDao {
	@Autowired
	SchoolRepository repository;
	
	@Override
	public School addSchoolName(School model) {
		return repository.save(model);
	}

	@Override
	public List<School> getAll() {
		return repository.findAll();
	}
	
	@Override
	public void deleteById(String id) {
		repository.deleteById(id);
		
	}

	@Override
	public School getByUsernameAndPassword(String schoolName, String schoolPlace) {
		return repository.findBySchoolNameAndSchoolPlace(schoolName, schoolPlace);
	}

	@Override
	public School getOneSchoolName(String id) {
		return repository.findById(id).orElseThrow();
	}

	@Override
	public School update(School school) {
		return repository.save(school);
	}
}
