<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
</head>
<body>
<h2>Login :</h2>
<pre>
<form action="/login" method="post">

Email :<input type="text" name="email" />

Password: <input type="password" name="password" />

<input type="submit" name="login" value="login"/>
${msg}

</form>
</pre>
</body>
</html>