package com.department.studentcrud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.department.studentcrud.entity.Student;
import com.department.studentcrud.exception.StudentNotFoundException;
import com.department.studentcrud.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	private List<Student> getData() {
		List<Student> theList = studentService.findAll();
		return theList;
	}
	
	@GetMapping("/students/{studentId}")
	private Student getStudent(@PathVariable int studentId) {
		
		Student theStudent = studentService.getById(studentId);
		if(theStudent == null) {
			throw new StudentNotFoundException("Student not found with id " + studentId);
		}
		return theStudent;
	}

	@PostMapping("/students")
	private void addStudent(@RequestBody Student theStudent) {
		theStudent.setId(0);
		studentService.save(theStudent);
	}
	
	@PutMapping("/students")
	private Student updateStudent(@RequestBody Student theStudent) {
		studentService.save(theStudent);
		return theStudent;
	}
	
	@DeleteMapping("/students/{studentId}")
	private String deleteStudent(@PathVariable int studentId) {
		
		Student theStudent = studentService.getById(studentId);
		if(theStudent == null) {
			throw new StudentNotFoundException("Student not found with id " + studentId);
		}
		studentService.deleteById(studentId);
		return "Deleted student with id " + studentId;
	}
	
	
	
}



