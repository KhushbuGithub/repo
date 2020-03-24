<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
<a href="./home">Home</a>
<a href="./logout" style="float: right;">Logout</a>
	<form action="./register" method="post">
		<table style="padding-left: 40%; padding-top: 10%;color: blue;">
			<tr>
				<td>${msg}</td>
			</tr>

			<tr>
				<td>Name</td>
				<td><input type="name" name="name"></td>
			</tr>

			<tr>
				<td>Email</td>
				<td><input type="email" name="email"></td>
			</tr>

			<tr>
				<td>Password</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>Mobile</td>
				<td><input type="number" name="mobile"></td>
			</tr>
			<tr>
				<td>Role</td>
				<td><select name="role">
						<option value="ADMIN">Admin</option>
						<option value="USER">USER</option>
				</select></td>
			</tr>
			<tr>
				<td><input type="submit" name="Register"></td>
			</tr>



		</table>

	</form>

</body>
</html>