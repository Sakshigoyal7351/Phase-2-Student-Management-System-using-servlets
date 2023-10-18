package com.student.dbconn;

import java.sql.Connection;
import java.sql.DriverManager;



public class DbConnection {
	
	public static Connection getConnection()
	{
		Connection con= null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/phase2";
			String uname="root";
			String pwd="Oneplusnord2@";
			con= DriverManager.getConnection(url,uname,pwd);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return con;
	}

	
	
	
}

