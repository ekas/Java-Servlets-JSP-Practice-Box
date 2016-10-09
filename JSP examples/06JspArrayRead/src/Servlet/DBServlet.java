package com.nucleus.ekas.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nucleus.ekas.ServiceLayer.ServiceLayer;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/DBServlet")
public class DBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		
		PrintWriter pw = response.getWriter();
		pw.println("Hello " + user + " your password is : " + pass);
		
		ServiceLayer sl = new ServiceLayer();
		boolean ret = sl.setVars(user, pass);
		
		
		if(ret == true){
			
			HttpSession setSession = request.getSession(true);
			setSession.setAttribute("userSessionName",user);
			
			response.sendRedirect("http://localhost:8081/08ServletCompCart/CartServlet");
			
		}
		else{
			response.sendRedirect("http://localhost:8081/04ServletDatabaseConnection/Login.html");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
