package com.department.studentcrud.dao;

import java.util.List;

import com.department.studentcrud.entity.Student;

public interface StudentDAO {

	public List<Student> findAll(); 
	
	public Student getById(int theId);
	
	public void save(Student theStudent);
	
	public void deleteById(int theId);

	
	
}
