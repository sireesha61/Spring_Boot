package com.school.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.school.bean.School;

public interface SchoolRepository extends MongoRepository<School, String>{

	School findBySchoolNameAndSchoolPlace(String schoolName, String schoolPlace);
}
