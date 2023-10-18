package com.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.dbconn.DbConnection;
import com.student.model.Student;
import com.student.service.StudentOperations;

/**
 * Servlet implementation class StudentReg
 */
@WebServlet("/StudentReg")
public class StudentReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentReg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sname= request.getParameter("txtSname");
		String course = request.getParameter("txtCourse");
		String fees = request.getParameter("txtFees");
		String email= request.getParameter("txtFees");
		String pswd = request.getParameter("txtPass");
		
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
	
		
		StudentOperations so = new StudentOperations();
		Student std = new Student();
		
		
		try
		{
			
			
			
			std.setStdname(sname);
			std.setCourse(course);
			std.setFees(Float.parseFloat(fees));
			std.setEmail(email);
			std.setPwd(pswd);
			
			String res=so.AddNewStudent(std); 
			
			if(res.equals("Success"))
			{
				response.sendRedirect("ShowAll");
			}
			
			
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
