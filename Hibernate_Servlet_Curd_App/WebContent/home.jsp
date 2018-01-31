<%@page import="com.anilnayak.service.LoginService"%>
<%@page import="java.nio.channels.SeekableByteChannel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date"%>
<%@ page import="com.anilnayak.pojo.User"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<center>
		<h1>Display Page</h1>
		<%=new Date()%><br>
		<%
			User user = (User) session.getAttribute("user");
		%>
		Welcome Mr./Miss.
		<%=user.getFirstName() + " " + user.getLastName()%>
		<br /> <a href="logout.jsp">Logout</a>

		<table border="1">
			<thead>
				<tr>
					<th>User ID</th>
					<th>First Name</th>
					<th>Middle Name</th>
					<th>Last Name</th>
					<th>email</th>
				</tr>
			</thead>
			<thead>
				<%
					LoginService service = new LoginService();
					List<User> listUser = service.getAllUserDetails();
					for (User u : listUser) {
				%>
				<tr>
					<td><%=u.getUserId()%></td>
					<td><%=u.getFirstName()%></td>
					<td><%=u.getMiddleName()%></td>
					<td><%=u.getLastName()%></td>
					<td><%=u.getEmail()%></td>
				</tr>
				<%
					}
				%>
			</thead>
		</table>
	</center>
</body>
</html>