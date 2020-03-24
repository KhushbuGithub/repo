
<%@page import="java.util.Date"%>
<%@include file="/index1.html"%>
<%-- <%@page extends="java.lang.Object" %> --%>
<%-- <%@page errorPage="/error.jsp" %> --%>
<%@page isThreadSafe="false"%>
<%@page session="false"%>


<%!private int i = 30;
	private String name = "rajj";

	public void printName() {
		System.out.println(name);
	}%>
<html>
<body>
	<%
		Date date = new Date();
		System.out.println("code 1");
	%>
	<h1 style="color: pink;"><%=date%></h1>
	<%
		System.out.println("code 2");
		//  System.out.println(1/0);
	%>
	<h1 style="color: blue;"><%=i%></h1>
	<%
		System.out.println("code 3");
		printName();
	%>
	<h1 style="color: green;"><%=name%></h1>

</body>
</html>
<%!public void jspInit() {
		System.out.println("Init method");
	}%>
<%!public void jspDestroy() {
		System.out.println("Destroy method");
	}%>