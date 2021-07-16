package com.department.studentcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.department.studentcrud.dao.StudentDAO;
import com.department.studentcrud.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAO;
	
	@Override
	@Transactional
	public List<Student> findAll( ) {	
		return studentDAO.findAll();
	}

	@Override
	@Transactional
	public Student getById(int theId) {

		return studentDAO.getById(theId);
	}

	@Override
	@Transactional
	public void save(Student theStudent) {
		studentDAO.save(theStudent);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		studentDAO.deleteById(theId);
	}

}
