package com.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.student.model.Student;
import com.student.service.StudentOperations;

/**
 * Servlet implementation class StudentInfo
 */
@WebServlet("/StudentInfo")
public class StudentInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		int rno= (Integer)session.getAttribute("rollno");
		StudentOperations so = new StudentOperations();
		
		Student std =so.SearchStudent(rno);
		
		out.print("<a href='StudentInfo' style='color:red;'>Home</a> &nbsp;&nbsp;&nbsp; | &nbsp;&nbsp;&nbsp<a href ='#'>Change Password</a>&nbsp;&nbsp;&nbsp; | &nbsp;&nbsp;&nbsp; <a href='Login.html'>Logout</a>");
		out.print("<hr />");
		
		out.print("<h1> Welcome to :"+std.getStdname()+"</h1>");
		out.print("<hr />");
		out.print("<table width='100%' border='1'>");
		
		out.print("<tr><th>Roll Number </th><th>Student name</th><th>Course </th><th>Fees</th><th>Email</th><th>Password</th></tr>");
		
		
			out.print("<tr>");
			out.print("<td>"+std.getRollno()+"</td>");
			out.print("<td>"+std.getStdname()+"</td>");
			out.print("<td>"+std.getCourse()+"</td>");
			out.print("<td>"+std.getFees()+"</td>");
			out.print("<td>"+std.getEmail()+"</td>");
			out.print("<td>"+std.getPwd()+"</td>");
			
			
			
			out.print("</tr>");
		
		out.print("</table>");
	}

}
