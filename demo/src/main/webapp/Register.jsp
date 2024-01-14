<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form  action="submitForm" method="post">
<input placeholder="name" type="text" name="name"></br></br>
<input placeholder="email" type="email" name="email"></br></br>
<input placeholder="password" type="password" name="password"></br></br>
<input type="radio" name="gender1" value="male"/>male <input type="radio" name="gender1" value="female"/>Female</br></br>
<select name="city">
<option>Select City</option>
<option>Pune</option>
<option>Mumbai</option>
<option>Latur</option>
<option>amravati</option>
<option>navi Mumbai</option>
</select></br></br>
<input type="submit" name="Register" value="Register"/>
<a href="Login">
<button type="button">Login</button></a>


</form>
</body>
</html>
