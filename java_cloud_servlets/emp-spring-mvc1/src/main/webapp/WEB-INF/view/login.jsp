<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<form action="./login" method="post">
	<table style="padding-left: 40%; color: blue; padding-top: 20%;">
		<tr>
			<td>${msg}</td>
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
			<td><input type="submit" name="login"></td>
		</tr>
	</table>

</form>



</body>
</html>