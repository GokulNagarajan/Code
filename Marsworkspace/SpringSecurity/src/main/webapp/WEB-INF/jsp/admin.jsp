<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Security</title>
</head>
<body>
<center>
<b>${head}</b>
<p>
<h2>${body}</h2>
<c:if test="${pageContext.request.userPrincipal.name != null}">
<h2>Welcome : ${pageContext.request.userPrincipal.name}
| <a href="<c:url value="/j_spring_security_logout" />" > Logout</a></h2>
</c:if>
<p>Admin page</p>
</center>
</body>
</html>