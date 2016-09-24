package com.calc.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormCalc
 */
@WebServlet("/f1")
public class FormCalc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormCalc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name1 = request.getParameter("num1");
		String name2 = request.getParameter("num2");
		int num1 = Integer.parseInt(name1);
		int num2 = Integer.parseInt(name2);
		int ans = 0;
		
		String radio = request.getParameter("optionsRadios");
		
		if(radio.equals("option1")){
			ans = num1 + num2;
		}
		else if(radio.equals("option2")){
			ans = num1 - num2;
		}
		else{
			ans = num1 * num2;
		}
		
		PrintWriter p = response.getWriter();
		p.print("<p> Answer is: "+ ans+"</p>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
