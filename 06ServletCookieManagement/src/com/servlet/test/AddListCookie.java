package com.servlet.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddListCookie
 */
@WebServlet("/AddListCookie")
public class AddListCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddListCookie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String button = request.getParameter("submit");
		String itemname = request.getParameter("itemname");
		String qty = request.getParameter("qty");
		
		
		
		if(button.equals("AddCookies")){
			Cookie ck = new Cookie(itemname,qty);
			response.addCookie(ck);
			response.sendRedirect("http://localhost:8081/06ServletCookieManagement/index.html");
			
		}
		if(button.equals("ListCookies")){
			PrintWriter pw = response.getWriter();
			Cookie[] ch = request.getCookies();
			for (int i = 0; i < ch.length ; i++) {
				pw.println(ch[i].getName()+" "+ch[i].getValue());
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
