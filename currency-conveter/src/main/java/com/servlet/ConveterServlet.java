package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ConveterServlet extends HttpServlet {

	double poundRate, dollarRate, euroRate;

	public void init() {
		ServletConfig config = this.getServletConfig();

		dollarRate = Double.parseDouble(config.getInitParameter("dollorRate"));
		poundRate = Double.parseDouble(config.getInitParameter("poundRate"));
		euroRate = Double.parseDouble(config.getInitParameter("euroRate"));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		int rupees = Integer.parseInt(req.getParameter("amt"));
		String convert = req.getParameter("cnvt");

		double amt = 0;

		switch (convert) {
		case "Dollar" -> {

			amt = rupees / dollarRate;
		}
		case "Pounds" -> {

			amt = rupees / poundRate;
		}
		case "Euro" -> {

			amt = rupees / euroRate;
		}

		}
		
		out.println("<h1>Converted Amount</h1>");
		out.println("<p>You Have Enter : "+ rupees +" Rs.</p>");
		
		out.println("<p>You Want to converted into : "+ convert +"</p>");
		
		if(convert.equals("Dollar")) {
			  out.println("<p>Converted Amount : "+ amt + "$</p>");
		}else if(convert.equals("Pounds")) {
			 out.println("<p>Converted Amount : "+ amt + " pound</p>");
		}else {
			 out.println("<p>Converted Amount : "+ amt + " euros</p>");
		}

	}
}
