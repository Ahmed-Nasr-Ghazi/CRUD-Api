package com.department.studentcrud.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.department.studentcrud.entity.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private EntityManager entityManager;
	
	
	@Override
	public List<Student> findAll() {

		Session session = entityManager.unwrap(Session.class);
		Query<Student> query = session.createQuery("from Student", Student.class);
		List<Student> studentList = query.getResultList();
		return studentList;
	}


	@Override
	public Student getById(int theId) {
		Session session = entityManager.unwrap(Session.class);
		Student theStudent = session.get(Student.class, theId);
		return theStudent;
	}


	@Override
	public void save(Student theStudent) {
		
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(theStudent);		
	}


	@Override
	public void deleteById(int theId) {
		
		Session session = entityManager.unwrap(Session.class);
		Query theQuery = session.createQuery("delete from Student where id=:studentId");
		theQuery.setParameter("studentId", theId);
		theQuery.executeUpdate();			
	}

}
