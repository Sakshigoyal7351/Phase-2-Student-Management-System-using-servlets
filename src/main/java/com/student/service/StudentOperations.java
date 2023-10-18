package com.student.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.student.dbconn.DbConnection;
import com.student.model.Student;

public class StudentOperations {

	private Connection conObj = null;

	public StudentOperations() {
		conObj=DbConnection.getConnection();
	}
	
	public String AddNewStudent(Student std)
	{
		String res ="Error";
		
		try
		{
			String inscmd = "Insert into Student(stdname,course, fees, email, pwd) value (?,?,?,?,?)";
		
			PreparedStatement ps = conObj.prepareStatement(inscmd);
			
			ps.setString(1, std.getStdname());
			ps.setString(2, std.getCourse());
			ps.setFloat(3, std.getFees());
			ps.setString(4, std.getEmail());
			ps.setString(5, std.getPwd());
			
			int r =ps.executeUpdate();

			if(r>=1)
			{
				res="Success";
			}
		}
		catch(Exception ex)
		{
			res=ex.getMessage();
			ex.printStackTrace();
		}
		return res;
	}
	
	public List<Student> showAll()
	{
		List<Student> sall = new ArrayList();
		
		Student std=null;
		
		try {
			PreparedStatement ps= conObj.prepareStatement("select * from student");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				std= new Student();
				std.setRollno(rs.getInt("rollno"));
				std.setStdname(rs.getString("stdname"));
				std.setCourse(rs.getString("course"));
				std.setFees(rs.getFloat("fees"));
				std.setEmail(rs.getString("email"));
				std.setPwd(rs.getString("pwd"));
				
				sall.add(std);
				
			}
			
		} 
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
		return sall;
	}
	
	
	public Student SearchStudent(int rollno)
	{
		Student std= null;
		
		try {
			
			PreparedStatement ps= conObj.prepareStatement("select * from Student where rollno=?");
			
			ps.setInt(1, rollno);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				std= new Student();
				std.setRollno(rs.getInt("rollno"));
				std.setStdname(rs.getString("stdname"));
				std.setCourse(rs.getString("course"));
				std.setFees(rs.getFloat("fees"));
				std.setEmail(rs.getString("email"));
				std.setPwd(rs.getString("pwd"));
			}
		} 
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return std;
	}
	
	
	public String DeleteStudent(int rollno)
	{
		String res="Error";
		try {
			
			String delcmd= "Delete from Student where rollno=?";
			
			PreparedStatement ps= conObj.prepareStatement(delcmd);
			ps.setInt(1, rollno);
			
			int r= ps.executeUpdate();
			
			if(r>=1)
			{
				res="Success";
			}
			
		} 
		catch (Exception ex) {
			res=ex.getMessage();
			ex.printStackTrace();
		}
		
		return res;
		
	}
	
	public String UpdateStudentName(Student std)
	{
		String res="Error";
		
		try {
			String uptcmd= "update Student set stdname=? where rollno=?";
			
			PreparedStatement ps = conObj.prepareStatement(uptcmd);
			ps.setString(1, std.getStdname());
			ps.setInt(2, std.getRollno());
			
			int r= ps.executeUpdate();
			if(r>=1)
			{
				res="Success";
				
			}
		
		}
		catch (Exception ex) {
			res=ex.getMessage();
			ex.printStackTrace();
		}
		
		return res;
		
	}
	
	
	public Student CheckUser(String uname, String pswd)
	{
		Student std= null;
		
		try {
			
			PreparedStatement ps= conObj.prepareStatement("select * from Student where email=? and pwd=?");
			
			ps.setString(1, uname);
			ps.setString(2, pswd);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				std= new Student();
				std.setRollno(rs.getInt("rollno"));
				std.setStdname(rs.getString("stdname"));
				std.setCourse(rs.getString("course"));
				std.setFees(rs.getFloat("fees"));
				std.setEmail(rs.getString("email"));
				std.setPwd(rs.getString("pwd"));
			}
		} 
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return std;
	}
	
	
	
	
	
	
}
