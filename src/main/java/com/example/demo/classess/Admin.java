package com.example.demo.classess;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String emailId;
private String password;
private String role;
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;

}
}


