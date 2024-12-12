<%@ page language="java" contentType="text/html; charset=UTF-8"
    isErrorPage="true" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error page</title>
</head>
<body>
	<p>Sorry an error has occurred!</p>
	<%=exception.getMessage()%>
</body>
</html>