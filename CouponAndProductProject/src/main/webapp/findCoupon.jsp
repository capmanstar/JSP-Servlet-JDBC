<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find coupon</title>
</head>
<body>
<h1>Find coupon</h1>
	<form action="coupons" method="post">
		<pre>
Code: <input type="text" name="couponCode" />
<input type="hidden"  name="action" value="find"/>
<input type="submit" value="find" />

</pre>
	</form>
</body>
</html>