<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>

<jsp:include page="../includes/header.jsp"/>
<jsp:include page="../includes/menu.jsp"/>
<jsp:include page="../includes/content.jsp"/>

<h2>Iniciar sesión</h2>
<% HttpSession sesion = request.getSession();
if (sesion.getAttribute("isLogin") == "false") { %>
<form method="post" action="<%=request.getContextPath()%>/UserCRUD">
	<table>
		<tr><td>nick</td><td><input type="text" name="name" size="40" /> </td></tr>
		<tr><td>password </td><td><input type="text" name="password" size="40" /> </td></tr>
		<tr><td colspan="2" align="center"><input type="submit" name="action" value="logIn" /> </td></tr>
	</table> 
</form>
<% } else { %>
<p>Saioa hasi duzu jadanik!</p>
<% } %>

<%if ( request.getAttribute("checkUserMsg") != null ) { %>
	<h2><%=request.getAttribute("checkUserMsg") %></h2>
<% } %>
<% if ( request.getAttribute("login") != null ) { 
	if (request.getAttribute("login").equals("ok")) {
		sesion.setAttribute("isLogin", "true");
	} else if (request.getAttribute("login").equals("error")) {
		sesion.setAttribute("isLogin", "false");
	}
}%>

<jsp:include page="../includes/sidebar.jsp"/>
<jsp:include page="../includes/footer.jsp"/>
