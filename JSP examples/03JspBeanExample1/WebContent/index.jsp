<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="com.jsp.test.Employee" %>

<jsp:useBean id="emp" class="com.jsp.test.Employee" scope="session">
	<jsp:setProperty name="emp" property="salary" value="40000"/>
	<jsp:setProperty name="emp" property="name" value="steve"/>
	<jsp:forward page="testJsp.jsp"/>
</jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>