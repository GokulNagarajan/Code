<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>home</title>
<link href="index.css" rel="stylesheet" type="text/css" />
<script src="index.js" type="text/javascript"></script>
<script type="text/javascript">
</script>
</head>
<body>
<div class="title">
<h2>Login Form</h2>
</div>
<div class="form">
<form id="Homeform" action="ViewPost" method="post" onsubmit="return func()">
<div class="Homecontent">
<p> 
<button type="button" name="login" onclick="location.href = 'login.jsp';" >Login</button>
<p>
<button type="button" name="register" onclick="location.href = 'index.jsp';">Register</button>
<p>
</div>
</form>
</div>
</body>
</html>