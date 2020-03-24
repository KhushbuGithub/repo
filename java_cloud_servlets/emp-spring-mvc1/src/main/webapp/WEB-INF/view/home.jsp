<%@page import="java.util.List"%>
<%@page import="com.capgemini.empspringmvc.dto.EmployeeInfoBean"%>
<%
	EmployeeInfoBean bean = (EmployeeInfoBean) session.getAttribute("bean");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<%
		
			if (bean.getRole().equals("ADMIN")) {
	%>
	<a href="./register">Add Employee</a>
	<%
		}
	%>

	<!-- <a href="#">Add Employee</a> -->
	<a href="./change-password">Change Password</a>
	<a href="./logout" style="float: right;">Logout</a>
	<h1>
		WELCOME
		<%= bean.getName()%></h1>

	<form action="./search">
		<input type="text" name="name" placeholder="Enter the name"> <input
			type="submit" value="Search">
	</form>
	<%
		List<EmployeeInfoBean> beans = (List<EmployeeInfoBean>) request.getAttribute("beans");
	%>

	<%
	    if (beans != null) {
		if (beans.isEmpty()) {
	%>

	<h1>Data NOt Found For the name</h1>
	<%
		} else {
	%>
	<table>
		<tr>
			<td>Name</td>
			<td>Email</td>
			<td>Mobile</td>
			<td>Role</td>
		</tr>
		<%
			for (EmployeeInfoBean infoBean : beans) {
		%>
		<tr>
			<td><%=infoBean.getName()%></td>
			<td><%=infoBean.getEmail()%></td>
			<td><%=infoBean.getMobile()%></td>
			<td <%=infoBean.getRole()%>></td>

		</tr>
		<%
			}
		%>

	</table>
	<%
		}
		}
	%>
</body>
</html>