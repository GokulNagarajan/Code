<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page language="java" import="java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UserDetails</title>
<link href="index.css" rel="stylesheet" type="text/css" />
<script src="index.js" type="text/javascript"></script>
</head>
<body>
<div class="title">
<h2>User Details</h2>
</div>
<div class="form">
<!-- <form name="TableForm" method="get" onsubmit="return validate()">
 -->
<div class="tablecontent">
<table>
<tr>
<th>User Name</th>
<th>Email Id</th>
<th>Phone</th>
<th>Country</th>
<th>Age</th>
<th>DOB</th>
</tr>
<%
Connection con =null;
Statement stmt =null;
ResultSet rs =null;
	try
	{
	Class.forName("com.mysql.jdbc.Driver");
	con= DriverManager.getConnection("jdbc:mysql://localhost:3306/home", "root","Welcome123");
	stmt= con.createStatement();
	rs=stmt.executeQuery("Select * from user");
	while(rs.next())
	{
%>
<tr>
<td><%=rs.getString(1) %></td>
<td><%=rs.getString(3) %></td>
<td><%=rs.getString(4) %></td>
<td><%=rs.getString(5) %></td>
<td><%=rs.getInt(6) %></td>
<td><%=rs.getDate(7)%></td>
</tr>
<%	
}
rs.close();
stmt.close();
con.close();
}catch(Exception e){
System.out.println(e.getMessage());
}
%>
</table>
</div>
<!-- </form>
-->
 </div>
 <form action="LogoutPost">
 <input type="button" class="button" name="logout" value="Logout" onclick="location.href = 'home.jsp';" />
 </form>
 <div>
 <table>
 <tr>
 <th>UserName</th>
 <th>Password</th>
 </tr>
 <c:forEach var="list" items="${userlist}">  
 <tr>
 <td><c:out value="${list.name}" /></td>
 <td><c:out value="${list.password}" /></td>
 </tr> 
 </c:forEach>
 </table>
 </div>
</body>
</html>