package com.htc.springjpausinghibernate.dao;

import java.util.List;

import com.htc.springjpausinghibernate.entity.Student;
import com.htc.springjpausinghibernate.exceptions.StudentNAException;
import com.htc.springjpausinghibernate.exceptions.StudentNotFoundException;

public interface IStudentDao {
	public boolean addStudent(Student student);
	public List<Student> getAllStudent() throws StudentNAException;
	public Student getStudentById(int studentId);
	public boolean updateStudent(int studentId,Student student);
	public boolean deleteStudent(int studentId) throws StudentNotFoundException; 

}
