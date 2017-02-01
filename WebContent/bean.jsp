<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="person" scope="application" class="isep.lab1.bean.Person" />
	<%
  		person.setFirstName(request.getParameter("firstname"));
  		person.setLastName(request.getParameter("lastname"));
  		person.setBirthDate(request.getParameter("birthdate"));
  		person.setSex(request.getParameter("sex"));
	%>
	
	<table>
		<tr><td>First name</td><td><jsp:getProperty property="firstName" name="person"/></td></tr>
	  	<tr><td>Last name</td><td><jsp:getProperty property="lastName" name="person"/></td></tr>
	  	<tr><td>Birth date</td><td><jsp:getProperty property="birthDate" name="person"/></td></tr>
	  	<tr><td>Sex</td><td><jsp:getProperty property="sex" name="person"/></td></tr>
	</table>
</body>
</html>