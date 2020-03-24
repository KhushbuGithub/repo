

<%@page import="java.util.Date"%>
<%!
private int i = 30;
private String name="ravi";

public void printName(){
	System.out.println(name);
}
%>
<html>
<body>
	<%
		Date date= new Date();
		System.out.println("code 1");
	%>
	<h1 style="color: pink;"><%=date%></h1>
	<%
		System.out.println("code 2");
	%>
	<h1 style="color:blue;"><%=i %></h1>
	<%
	System.out.println("code 3");
	printName();
	%>
	<h1 style="color:red;"><%=name %></h1>
	
</body>
</html>