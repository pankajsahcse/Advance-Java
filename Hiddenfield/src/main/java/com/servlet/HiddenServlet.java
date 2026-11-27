package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HiddenServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		int value = Integer.parseInt(request.getParameter("cnt"));
		value++;

		out.println("<h1>Count: " + value + "</h1>");
		
		out.println("<form action='" + request.getContextPath() + "/hidden' method='post'>");
		out.println("<input type = 'hidden' name = 'cnt' value ='" + value + "'/>");
		out.println("<button type = 'submit' name = 'btn' >Clickme</button>");
		out.println("</form>");
	}

}
