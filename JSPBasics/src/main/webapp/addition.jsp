<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Addition JSP</title>
</head>
<body>

<% 
	int num1 = Integer.parseInt(request.getParameter("number1"));
	int num2 = Integer.parseInt(request.getParameter("number2"));
%>

Sum of <%=num1 %> and <%=num2 %> is <%=num1+num2 %>
</body>
</html>