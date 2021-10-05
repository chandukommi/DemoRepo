package com.htc.springjpausinghibernate.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.htc.springjpausinghibernate.dao.IStudentDao;
import com.htc.springjpausinghibernate.entity.Student;
import com.htc.springjpausinghibernate.exceptions.StudentNAException;
import com.htc.springjpausinghibernate.exceptions.StudentNotFoundException;

@Service
public class StudentServiceImplementation implements IStudentService{
	@Autowired
	IStudentDao studentDao;
	
	
	@Override
	@Transactional
	public boolean addStudent(Student student) {
		// TODO Auto-generated method stub
		System.out.println("In service class");
		
		boolean addStudentFlag = false;
		
		if(student!=null)
		{
			studentDao.addStudent(student);
			addStudentFlag = true;
		}
		
		return addStudentFlag;
	}

	@Override
	@Transactional
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		List<Student> studentlist=null;
		try {
			studentlist= studentDao.getAllStudent();
		} catch (StudentNAException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentlist;
	}

	@Override
	@Transactional
	public boolean updateStudent(int studentId, Student student) {
		// TODO Auto-generated method stub
    boolean addUpdateFlag = false;
		
		if(student!=null)
		{
			studentDao.updateStudent(studentId, student);
			addUpdateFlag = true;
		}
		
		return addUpdateFlag;
	}

	@Override
	@Transactional
	public Student getStudentbyId(int studentId) {
		// TODO Auto-generated method stub
		Student student=null;
		student=studentDao.getStudentById(studentId);
	
	return student;
	}

	@Override
	@Transactional
	public boolean deleteStudent(int studentId) throws StudentNotFoundException {
		// TODO Auto-generated method stub
boolean deleteFlag = false;
		
		if(studentId!=0)
		{
			studentDao.deleteStudent(studentId);
			deleteFlag = true;
		}
		
		return deleteFlag;
	}

}
