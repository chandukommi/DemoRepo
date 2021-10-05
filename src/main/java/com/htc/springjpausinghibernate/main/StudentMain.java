package com.htc.springjpausinghibernate.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.htc.springjpausinghibernate.configuration.JPAConfiguration;
import com.htc.springjpausinghibernate.entity.Student;
import com.htc.springjpausinghibernate.exceptions.StudentNotFoundException;
import com.htc.springjpausinghibernate.service.IStudentService;

public class StudentMain {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JPAConfiguration.class);
		
		IStudentService studentService = applicationContext.getBean(IStudentService.class);
		
		studentService.addStudent(new Student("mahi",89,98,80));
		studentService.addStudent(new Student("sagar",56,95,96));
		studentService.addStudent(new Student("sai",98,56,65));
		System.out.println(studentService.getAllStudent());
		
		
		/*
		//System.out.println(studentService.getStudentbyId(19));
		//studentService.updateStudent(108,new Student("raj",96,68,80));
		//System.out.println(studentService.getStudentbyId(19));
		try {
			studentService.deleteStudent(19);
		} catch (StudentNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			*/
		
		
		}
		
	
}
