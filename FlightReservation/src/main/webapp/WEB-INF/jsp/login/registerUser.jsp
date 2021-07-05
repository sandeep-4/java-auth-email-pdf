<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register User</title>
</head>
<body>

<h2>User Registration</h2>
<pre>
<form action="registerUser" method="post">
First Name : <input type="text" name="firstname" /> 

SecondName : <input type="text" name="lastname" />

Email : <input type="text" name="email" />

Password : <input type="password" name="password" />

Confirm Password : <input type="password" name="confirmPassword" />

                          <input type="submit" name="register" value="register"/>
</form>
</pre>
</body>
</html>