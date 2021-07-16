package com.department.studentcrud.service;

import java.util.List;

import com.department.studentcrud.entity.Student;

public interface StudentService {

	public List<Student> findAll(); 
	
	public Student getById(int theId);
	
	public void save(Student theStudent);
	
	public void deleteById(int theId);
	
}
