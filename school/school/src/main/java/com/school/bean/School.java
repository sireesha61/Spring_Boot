package com.school.bean;

import org.springframework.data.annotation.Id;

public class School {
	@Override
	public String toString() {
		return "School [id=" + id + ", schoolName=" + schoolName + ", schoolPlace=" + schoolPlace + "]";
	}
	@Id
	private String id;
	private String schoolName;
	private String schoolPlace;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getSchoolPlace() {
		return schoolPlace;
	}
	public void setSchoolPlace(String schoolPlace) {
		this.schoolPlace = schoolPlace;
	}
	
	

}
