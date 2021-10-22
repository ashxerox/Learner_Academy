package com.learner.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aopalliance.aop.AspectException;

import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequestWrapper;
import net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.Dispatcher;

//@WebServlet("/loginServlet")
public class LoginServlet extends jakarta.servlet.http.HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequestWrapper request, ServletResponse response)
			throws AspectException, IOException {
		String sname = request.getParameter("username");
		String sphone = request.getParameter("password");
		try {
			// load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// creating a connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/first_db", "root", "password");
			// here first_db is database name, root is username and password is password

			//Statement statement = con.createStatement();
			//ResultSet rs = statement.executeQuery("select * from studentnew where name='"+sname+"' and email='"+ sphone+"'" );
			//System.out.println("hello i am working");
			
			PreparedStatement stmt=con.prepareStatement("select * from studentnew where name='"+sname+"' and email='"+ sphone+"'" );  
			ResultSet rs=stmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2));
				System.out.println("hello i am working 2");
				jakarta.servlet.RequestDispatcher rd = request.getRequestDispatcher("studentHome.jsp");
				rd.forward(request, response);
			}
			if(rs.next()) {
			
			}
			
			//System.out.println("hello i am working 3");
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		//System.out.println("hello i am working 4");

	}

}
