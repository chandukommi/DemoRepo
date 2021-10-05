package com.htc.mavenspringjpahibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.htc.springjpausinghibernate.configuration.JPAConfiguration;
import com.htc.springjpausinghibernate.entity.Student;
import com.htc.springjpausinghibernate.exceptions.StudentNotFoundException;
import com.htc.springjpausinghibernate.service.IStudentService;
import com.htc.springjpausinghibernate.service.StudentServiceImplementation;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JPAConfiguration.class);
	
	IStudentService studentService = applicationContext.getBean(IStudentService.class);
  
    @Test
    public void addStudentTest()
    {
    Student student = new Student("mani",78,80,98);
   
        assertEquals(true, studentService.addStudent(student));
    }
   @Test
    public void updateStudentTest()
    {
	   Student student = new Student("bobby",80,80,88);
    	assertEquals(true,studentService.updateStudent(121,student));
    }
    @Test
    public void deleteStudentTest()
    {
    	try {
			assertEquals(true,studentService.deleteStudent(122));
		} catch (StudentNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    @Test
    public void getallStudentTest()
    {
    	assertNotNull(studentService.getAllStudent());
    }
    @Test
    public void searchStudentTest()
    {
    	assertNotNull(studentService.getStudentbyId(123));
    }
}


   
