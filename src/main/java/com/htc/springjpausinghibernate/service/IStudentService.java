package com.htc.springjpausinghibernate.service;

import java.util.List;

import com.htc.springjpausinghibernate.entity.Student;
import com.htc.springjpausinghibernate.exceptions.StudentNotFoundException;

public interface IStudentService {
	public boolean addStudent(Student student);
	public List<Student> getAllStudent();
	public boolean updateStudent(int studentId, Student student);
	public Student getStudentbyId(int studentId);
	public boolean deleteStudent(int studentId) throws StudentNotFoundException; 


}
