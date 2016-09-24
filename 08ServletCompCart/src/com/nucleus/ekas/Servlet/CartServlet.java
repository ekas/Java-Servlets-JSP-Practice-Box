package com.nucleus.ekas.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nucleus.ekas.DAO.LoginMain;
import com.nucleus.ekas.ServiceLayer.ServiceLayer;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession getSession = request.getSession(false);
		String user = (String) getSession.getAttribute("userSessionName");
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.print("<!DOCTYPE html><html><head><meta charset='ISO-8859-1'><meta name='viewport' content='width=device-width, initial-scale=1'><title>Product Page</title><link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css' integrity='sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u' crossorigin='anonymous'><style type='text/css'>.custom-container{margin: 50px auto 0 auto;width: 600px;-webkit-box-shadow: 4px 6px 13px -1px rgba(130,126,130,0.64);-moz-box-shadow: 4px 6px 13px -1px rgba(130,126,130,0.64);box-shadow: 4px 6px 13px -1px rgba(130,126,130,0.64);padding: 50px;}.custom-button{margin-right: 10px;color: white;background-color: #66afe9;padding : 8px 20px 8px 20px;border-radius: 2px;border: 1px solid #66afe9;}.custom-button:hover{color: #66afe9;background-color: #ffffff;border: 1px solid #66afe9;}</style></head><body><nav class='navbar navbar-default'> <div class='container-fluid'> <div class='navbar-header'> <button type='button' class='navbar-toggle collapsed' data-toggle='collapse' data-target='#bs-example-navbar-collapse-1' aria-expanded='false'> <span class='sr-only'>Toggle navigation</span> <span class='icon-bar'></span> <span class='icon-bar'></span> <span class='icon-bar'></span></button> <a class='navbar-brand' href='#'>Brand</a> </div><div class='collapse navbar-collapse' id='bs-example-navbar-collapse-1'> <ul class='nav navbar-nav navbar-right'> <li class='dropdown'> <a href='#' class='dropdown-toggle' data-toggle='dropdown' role='button' aria-haspopup='true' aria-expanded='false'>New User? <span class='caret'></span></a> <ul class='dropdown-menu'> <li><a href='form.html'>User Form</a></li></ul> </li></ul> </div></div></nav><div class='container'><div class='custom-container'><div class='custom-form'><form name='myForm' action='http://localhost:8081/08ServletCompCart/CartServlet' method='post'><h2>Hello "+user+"</h2><h3>Product Inventory</h3> <div class='form-group'> <label for='exampleInputEmail1'>Item Name</label> <input type='text' class='form-control' id='email' placeholder='Item Name' name='itemname'> </div><div class='form-group'> <label for='exampleInputEmail1'>Item Quantity</label> <input type='text' class='form-control' id='email' placeholder='Item Quantity' name='itemqty'> </div><input class='custom-button btn btn-default' type='submit' name='btn' value='Add'> <input class='custom-button btn btn-default' type='submit' name='btn' value='Buy'> <input class='custom-button btn btn-default' type='submit' name='btn' value='Search'> <input class='custom-button btn btn-default' type='submit' name='btn' value='Delete '></form></div></div></div><script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js'></script><script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js' integrity='sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa' crossorigin='anonymous'></script><script></script><script type='text/javascript'>$(function(){$('#button').click(function(){var x=document.getElementById('itemname').value; var patt=/^[a-zA-Z]*$/;if (x.length===0){alert('Item Name is mandatory'); return false;}if(patt.test(x)===false){alert('Item Name can only have characters');}}});});</script></body></html>");
		
		/*
		pw.println("<html><h1>Hello "+ user +"</h1>");		
		pw.print("<form action='http://localhost:8081/08ServletCompCart/CartServlet' method='post'>");
		pw.print("Enter Item Name <input type='text' name='itemname'><br><br>");
		pw.print("Enter Item Quantity<input type='text' name='itemqty'><br><br>");
		pw.print("<input type='submit' name = 'btn' value = 'Add'>");
		pw.print("<input type='submit' name = 'btn' value = 'Buy'>");
		pw.print("<input type='submit' name = 'btn' value = 'Search'>");
		pw.print("<input type='submit' name = 'btn' value = 'Delete'>");
		//pw.print("<input type='submit' name = 'btn' value = 'Delete'>");
		pw.print("</form></html>");*/
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String button = null;
		String itemname = null;
		String itemqty = null;
		Boolean ret = false;
		String str = null;
		
		button = request.getParameter("btn");		
		PrintWriter pw = response.getWriter();		
		ServiceLayer sl = new ServiceLayer();		
		
		
		if(button.equals("Add")){
			itemname = request.getParameter("itemname");
			itemqty = request.getParameter("itemqty");	
			Float itemqtyf = Float.parseFloat(itemqty);
			sl.setVarsItem(itemname,itemqtyf);
			ret = sl.setAddItem();
			if(ret == true){
				str = "Record Added";
			}
			else{
				str = "Redundant Record and Quantity Updated";
			}
		}
		else if(button.equals("Buy")){
			itemname = request.getParameter("itemname");
			itemqty = request.getParameter("itemqty");	
			Float itemqtyf = Float.parseFloat(itemqty);
			sl.setVarsItem(itemname,itemqtyf);
			ret = sl.setBuyItem();
			if(ret == true){
				str = "Item Purchased";
			}
			else{
				str = "Item Can't be bought out of Stock or Item Not Available";
			}
		}
		else if(button.equals("Search")){
			itemname = request.getParameter("itemname");
			sl.setVarsItem(itemname);
			float val  = sl.setSearchItem();
			if(val < 0){
				str = "Record not Found";
			}
			else{
				str = "Record Found : Item - " + itemname + " has Quantity of : " + val;
			}
		}
		else if(button.equals("Delete")){
			itemname = request.getParameter("itemname");
			sl.setVarsItem(itemname);
			ret = sl.setDeleteItem();
			if(ret == true){
				str = "Record Deleted";
			}
			else{
				str = "Record not Found";
			}
		}
		
		pw.print("<!DOCTYPE html><html><head><meta charset='ISO-8859-1'><meta name='viewport' content='width=device-width, initial-scale=1'><title>Product Page</title><link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css' integrity='sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u' crossorigin='anonymous'><style type='text/css'>.custom-container{margin: 50px auto 0 auto;width: 600px;-webkit-box-shadow: 4px 6px 13px -1px rgba(130,126,130,0.64);-moz-box-shadow: 4px 6px 13px -1px rgba(130,126,130,0.64);box-shadow: 4px 6px 13px -1px rgba(130,126,130,0.64);padding: 50px;}.custom-button{margin-right: 10px;color: white;background-color: #66afe9;padding : 8px 20px 8px 20px;border-radius: 2px;border: 1px solid #66afe9;}.custom-button:hover{color: #66afe9;background-color: #ffffff;border: 1px solid #66afe9;}</style></head><body><nav class='navbar navbar-default'> <div class='container-fluid'> <div class='navbar-header'> <button type='button' class='navbar-toggle collapsed' data-toggle='collapse' data-target='#bs-example-navbar-collapse-1' aria-expanded='false'> <span class='sr-only'>Toggle navigation</span> <span class='icon-bar'></span> <span class='icon-bar'></span> <span class='icon-bar'></span></button> <a class='navbar-brand' href='#'>Brand</a> </div><div class='collapse navbar-collapse' id='bs-example-navbar-collapse-1'> <ul class='nav navbar-nav navbar-right'> <li class='dropdown'> <a href='#' class='dropdown-toggle' data-toggle='dropdown' role='button' aria-haspopup='true' aria-expanded='false'>New User? <span class='caret'></span></a> <ul class='dropdown-menu'> <li><a href='form.html'>User Form</a></li></ul> </li></ul> </div></div></nav><div class='container'><div class='custom-container'><div class='custom-form'><form name='myForm' action='http://localhost:8081/08ServletCompCart/CartServlet' method='get'><h2>Hello</h2><h3>Product Inventory</h3><h5>"+str+"</h5> <input class='custom-button btn btn-default' id='button' type='submit' name='btn' value='Back'></form></div></div></div><script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js'></script><script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js' integrity='sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa' crossorigin='anonymous'></script></body></html>");
	}

}
