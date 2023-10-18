package com.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.model.Student;
import com.student.service.StudentOperations;

/**
 * Servlet implementation class ShowAll
 */
@WebServlet("/ShowAll")
public class ShowAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		StudentOperations so = new StudentOperations();
		
		try
		{
			
			
			
			List<Student> sall = so.showAll(); 
			
			
			out.print("<a href='AddnewStudent.html'style='color:red;'>New Student</a>");
			
			out.print("<br>");
			out.print("<hr>");
			out.print("<table width='100%' border='1'>");
			
			out.print("<tr><th>Roll Number </th><th>Student name</th><th>Course </th><th>Fees</th><th>Email</th><th>Password</th></tr>");
			
			for(Student std : sall)
			{
				out.print("<tr>");
				out.print("<td>"+std.getRollno()+"</td>");
				out.print("<td>"+std.getStdname()+"</td>");
				out.print("<td>"+std.getCourse()+"</td>");
				out.print("<td>"+std.getFees()+"</td>");
				out.print("<td>"+std.getEmail()+"</td>");
				out.print("<td>"+std.getPwd()+"</td>");
				out.print("<td><a href='DeleteStudent?rno="+std.getRollno()+"'>Delete</a></td>");
				
				
				out.print("</tr>");
			}
			
			out.print("</table>");
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
