<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 在<!DOCTYPE html 后面，原本有下面这句话 -->
<!-- PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd" -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>

<h2>Hello World!</h2>
<form action="login.do" method="post">
    username:<input type="text" name = "username" ><p> 
    password:<input type="password" name = "password" ><p>
    <input type="submit" value="登录"> 
</form>
</body>
</html>