<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>

<jsp:include page="../includes/header.jsp"/>
<jsp:include page="../includes/menu.jsp"/>
<jsp:include page="../includes/content.jsp"/>

<h2>Crea un usuario</h2><br>
<form method="post" action="<%=request.getContextPath()%>/UserCRUDv2">
	<table>
		<tr><td>nick</td><td><input type="text" name="name" size="40" /> </td></tr>
		<tr><td>email</td><td> <input type="text" name="email" size="40" /> </td></tr>
		<tr><td>password </td><td><input type="text" name="password" size="40" /> </td></tr>
		<tr><td colspan="2" align="center"><input type="submit" name="action" value="addUser" /> </td></tr>
		</table> 
</form>

<%if ( request.getAttribute("addUserMsg") != null ) { %>
	<h2><%=request.getAttribute("addUserMsg") %></h2>

<% } %>



<jsp:include page="../includes/sidebar.jsp"/>
<jsp:include page="../includes/footer.jsp"/>



