<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<jsp:include page="index.jsp"></jsp:include>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br>
	<fieldset>
		<legend>Register Form</legend>
		<form action="./register" method="post">
			<table>
				<tr>
					<td>UserName</td>
					<td>:</td>
					<td><input type="text" name="username" required></td>
				</tr>
				<tr>
					<td>Password</td>
					<td>:</td>
					<td><input type="password" name="password" required></td>
				</tr>
				<tr>
					<td>Role</td>
					<td>:</td>
					<td><input type="radio" name="role" value="ROLE_ADMIN">Admin<br>
						<input type="radio" name="role" value="ROLE_USER">User</td>
				</tr>
				<tr>
					<td>Mobile</td>
					<td>:</td>
					<td><input type="number" name="mobile" required></td>
				</tr>
				<tr>
				    <td colspan="3" align="center"><br> 
				         <input type="submit" value="Register">
					</td>
				</tr>
			</table>
		</form>
	</fieldset>
	<div>
	<h4 style="color:green"> ${msg} </h4>
	<h4 style="color:red">${errMsg}</h4>
	
	</div>
</body>
</html>