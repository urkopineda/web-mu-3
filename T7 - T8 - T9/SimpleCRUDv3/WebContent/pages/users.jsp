<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>
<%@ page import="simpleCRUD.domain.users.model.*" %>

<jsp:include page="../includes/header.jsp"/>
<jsp:include page="../includes/menu.jsp"/>
<jsp:include page="../includes/content.jsp"/>


<h2>Alumnos actuales</h2><br>
<form method="post" action="<%=request.getContextPath()%>/UserCRUDv2">
	<p><input type="text" name="provincia" size="40"><input type="submit" name="action" value="filtrarPorProvincia"/></p>
</form>
<table>
<% if (request.getAttribute("correct") != null) {
if (request.getAttribute("correct").equals("true")) {
	Users users = (Users) request.getAttribute("listAlumnos");
	for (int i = 0; i < users.getSize(); i++) {
		User user = users.getAlumnoAt(i);%>
		<tr>
			<td><%= user.getuId() %></td>
			<td><%= user.getuNombre() %></td>
			<td><%= user.getuApellido() %></td>
			<td><%= user.getuProvincia() %></td>
			<td><%= user.getuEmail() %></td>
		</tr>
<% 	}
	}
}%>
</table>
<br></br> 
<jsp:include page="../includes/sidebar.jsp"/>
<jsp:include page="../includes/footer.jsp"/>


