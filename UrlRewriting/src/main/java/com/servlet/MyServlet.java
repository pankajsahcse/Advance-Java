package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/urlChanging")
public class MyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("MyServlet Page");
		
		int cnt = Integer.parseInt(request.getParameter("count"));
		
		cnt++;
		
		out.println("<h2>You Have Clicked " + cnt + " times </h2>");
		
		out.println("<a href= 'urlChanging?count=" + cnt +"' > Click Me </a>");
		
		
		
	}

}
