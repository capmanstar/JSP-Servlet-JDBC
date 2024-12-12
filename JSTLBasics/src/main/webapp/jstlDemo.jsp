<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL COUT</title>
</head>
<body>
<%
List<String> students = new ArrayList<String>();
students.add("Darshan");
students.add("Om");
students.add("Sonawane");
%>

<fmt:parseNumber>123</fmt:parseNumber>

<c:forEach var="stud" items="${students}">
	<c:out value="${stud}"></c:out>
</c:forEach>
</body>
</html>