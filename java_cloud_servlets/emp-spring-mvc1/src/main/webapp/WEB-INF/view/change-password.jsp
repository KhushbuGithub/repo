<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password</title>
</head>
<body>
	<a href="/home">Home</a>
	<a href="./logout" style="padding-right: 20%;">Logout</a>
	<form action="./change-password" method="post">
		<table style="padding-left: 40%; padding-top: 20%">
			<tr>
				<td>New Password</td>
				<td><input type="password" name="password"
					placeholder="Enter new Password"></td>

			</tr>
			<tr>
				<td><input type="submit" value="Search"></td>
			</tr>
		</table>


	</form>

</body>
</html>