<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login here</title>
</head>
<body>
	<form action="j_security_check" method="post">
		User name: <input name="j_username" type="text" /><br> Password:
		<input name="j_password" type="password" /><br> <input
			type="submit" value="submit" />
	</form>
</body>
</html>