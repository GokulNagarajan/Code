<%@page import="java.util.List"%>
<%@page import="com.mindtree.university.entity.Department"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	var xhr;

	function fnGetDepts() {
		var dd = document.f1.department;
		var deptId = dd.options[dd.selectedIndex].value;

		var url = "listStudents.do?dept_id=" + deptId;
		if (window.ActiveXObject) {
			xhr = new ActiveXObject("Microsoft.XMLHTTP");
		} else {
			xhr = new XMLHttpRequest();
		}

		xhr.open("GET", url, false);
		xhr.send(null);
		document.getElementById("students").innerHTML = xhr.responseText;

	}
</script>
</head>
<body>
	<h1>Show students</h1>
	<form name="f1">
		Select Department: <select name="department" onchange="fnGetDepts()">
			<option value="-1">--SELECT--</option>
			<%
				List<Department> depts = (List<Department>) request.getAttribute("depts");
				for (Department dept : depts) {
					out.println("<option value=\"" + dept.getId() + "\">" + dept.getName() + "</option>");
				}
			%>
		</select>
	</form>
	<br/>
	<br/>
	<div id="students"></div>
</body>
</html>