package com.school.bean;
import org.springframework.data.annotation.Id;
public class Student {
	@Id
	private String id;
	private String stdUsername;
	private String stdPassword;
	public String getStdUsername() {
		return stdUsername;
	}
	public void setStdUsername(String stdUsername) {
		this.stdUsername = stdUsername;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStdPassword() {
		return stdPassword;
	}
	public void setStdPassword(String stdPassword) {
		this.stdPassword = stdPassword;
	}
		
}
