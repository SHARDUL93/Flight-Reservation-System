<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
</head>
<body>
	<h4 style="color:blue;">Login:</h4>
	<br>
	<form action="login" method="post">
		<pre>
			User Name: <input type="text" name="email" /><br>
			Password: <input type="password" name="password" /><br>
			<input type="submit" value="login" /><br>
			${msg}
		</pre>
	</form>
</body>
</html>