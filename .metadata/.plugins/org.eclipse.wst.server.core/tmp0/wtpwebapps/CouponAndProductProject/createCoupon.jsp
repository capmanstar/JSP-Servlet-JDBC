<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Coupon</title>
</head>
<body>
	<h1>Create coupon</h1>
	<form action="coupons" method="post">
		<pre>
Coupon code: <input type="text" name="couponCode" />

Discount: <input type="text" name="discount" />

Expiry date: <input type="text" name="expiryDate" />
<input type="hidden" name="action" value="create"/>
<input type="submit" value="save"/>

</pre>
	</form>
</body>
</html>