<%@page import="java.util.List"%>
<%@page import="com.mindtree.university.entity.Student"%>
<table border="1">
	<%
		List<Student> stdnts = (List<Student>) request.getAttribute("students");
		for (Student stdnt : stdnts) {
			out.println("<tr>");
			out.println("<td>" + stdnt.getId() + "</td>");
			out.println("<td>" + stdnt.getFirstName() + "</td>");
			out.println("<td>" + stdnt.getLastName() + "</td>");
			out.println("</tr>");
		}
	%>
</table>