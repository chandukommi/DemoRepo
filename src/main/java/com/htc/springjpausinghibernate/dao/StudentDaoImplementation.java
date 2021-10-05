package com.htc.springjpausinghibernate.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.htc.springjpausinghibernate.entity.Student;
import com.htc.springjpausinghibernate.exceptions.StudentNAException;
import com.htc.springjpausinghibernate.exceptions.StudentNotFoundException;

@Repository
public class StudentDaoImplementation implements IStudentDao{
	

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	
	@Override
	public boolean addStudent(Student student) {
		// TODO Auto-generated method stub
		boolean addStudentFlag = false;
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try
		{
			entityTransaction.begin();
			entityManager.persist(student);
			entityTransaction.commit();
			addStudentFlag = true;
		}
		catch(Exception e)
		{
			entityTransaction.rollback();
			e.printStackTrace();
		}
		finally {
			entityManager.close();
		}
		return addStudentFlag;
	}
	

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		List<Student> studentList = new ArrayList<Student>();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try
		{
			entityTransaction.begin();
			Query query = entityManager.createQuery(" from Student");
			studentList = query.getResultList();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return studentList;
	}

	@Override
	public Student getStudentById(int studentId) {
		// TODO Auto-generated method stub
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		return entityManager.find(Student.class, studentId);
	}

	@Override
	public boolean updateStudent(int studentId, Student student) {
		// TODO Auto-generated method stub
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		  boolean updateflag=false;
		  try {
		  entityTransaction.begin();
			Student ustudent=(Student)entityManager.find(Student.class, studentId);
			ustudent.setStudentName(student.getStudentName());
			ustudent.setTestMarks(student.getTestMarks());
			ustudent.setInterviewMarks(student.getInterviewMarks());
			ustudent.setSoftskillMarks(student.getSoftskillMarks());
			
			updateflag=true;
			entityTransaction.commit();
		  }
		  catch(Exception e)
			{
				entityTransaction.rollback();
				e.printStackTrace();
			}
			finally {
				entityManager.close();
			}
			return updateflag;
	}


	@Override
	public boolean deleteStudent(int studentId) throws StudentNotFoundException {
		// TODO Auto-generated method stub
		boolean deleteStudentFlag = false;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try
		{
			entityTransaction.begin();
			Student student=(Student)entityManager .find(Student.class, studentId);
			entityManager.remove(student);
			entityTransaction.commit();
			deleteStudentFlag = true;
		}
		catch(Exception e)
		{
			entityTransaction.rollback();
			throw new StudentNotFoundException("studentId not found for search");
		}
		finally {
			entityManager.close();
		}
		return deleteStudentFlag;
	
		
			
	}

	

}
