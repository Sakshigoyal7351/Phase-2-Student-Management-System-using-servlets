package com.student.model;

public class Student {
	private int rollno;
	private String stdname;
	private String course;
	private float fees;
	private String email;
	private String pwd;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int rollno, String stdname, String course, float fees, String email, String pwd) {
		super();
		this.rollno = rollno;
		this.stdname = stdname;
		this.course = course;
		this.fees = fees;
		this.email = email;
		this.pwd = pwd;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getStdname() {
		return stdname;
	}
	public void setStdname(String stdname) {
		this.stdname = stdname;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public float getFees() {
		return fees;
	}
	public void setFees(float fees) {
		this.fees = fees;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", stdname=" + stdname + ", course=" + course + ", fees=" + fees
				+ ", email=" + email + ", pwd=" + pwd + "]";
	}
	
	
}
