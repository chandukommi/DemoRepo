package com.htc.springjpausinghibernate.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="studentjpa2")
public class Student {
	
	@Id
	@GeneratedValue
	
	private int studentId;
	private String studentName;
	private int testMarks;
	private int interviewMarks;
	private int softskillMarks;
	//private List<Address> address;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Student(int studentId, String studentName, int testMarks, int interviewMarks, int softskillMarks) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.testMarks = testMarks;
		this.interviewMarks = interviewMarks;
		this.softskillMarks = softskillMarks;
	}

	public Student(String studentName, int testMarks, int interviewMarks, int softskillMarks) {
		super();
		this.studentName = studentName;
		this.testMarks = testMarks;
		this.interviewMarks = interviewMarks;
		this.softskillMarks = softskillMarks;
	}

	/*
	 * public Student(int studentId, String studentName, int testMarks, int
	 * interviewMarks, int softskillMarks, List<Address> address) { super();
	 * this.studentId = studentId; this.studentName = studentName; this.testMarks =
	 * testMarks; this.interviewMarks = interviewMarks; this.softskillMarks =
	 * softskillMarks; this.address = address; }
	 */
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getTestMarks() {
		return testMarks;
	}
	public void setTestMarks(int testMarks) {
		this.testMarks = testMarks;
	}
	public int getInterviewMarks() {
		return interviewMarks;
	}
	public void setInterviewMarks(int interviewMarks) {
		this.interviewMarks = interviewMarks;
	}
	public int getSoftskillMarks() {
		return softskillMarks;
	}
	public void setSoftskillMarks(int softskillMarks) {
		this.softskillMarks = softskillMarks;
	}

	/*
	 * public List<Address> getAddress() { return address; } public void
	 * setAddress(List<Address> address) { this.address = address; }
	 */
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + studentId;
		return result;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", testMarks=" + testMarks
				+ ", interviewMarks=" + interviewMarks + ", softskillMarks=" + softskillMarks + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (studentId != other.studentId)
			return false;
		return true;
	}
}