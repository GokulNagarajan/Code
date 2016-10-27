<%@page import="java.util.List"%>
<%@page import="com.mindtree.university.entity.Department"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Add Student</h1>
	<form action="addStudent.do" method="post">
		<table>
			<tr>
				<td>Firstname</td>
				<td><input type="text" size="15" name="firstName" /></td>
			</tr>
			<tr>
				<td>Lastname</td>
				<td><input type="text" size="15" name="lastName" /></td>
			</tr>
			<tr>
				<td>Department</td>
				<td><select name="department">
						<option value="-1">--SELECT--</option>
						<%
							List<Department> depts = (List<Department>) request.getAttribute("depts");
							for (Department dept : depts) {
								out.println("<option value=\"" + dept.getId() + "\">" + dept.getName() + "</option>");
							}
						%>
				</select></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Add" /></td>
			</tr>
		</table>
	</form>
</body>
</html>