<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>

<jsp:include page="../includes/header.jsp"/>
<jsp:include page="../includes/menu.jsp"/>
<jsp:include page="../includes/content.jsp"/>

<h2>Cerrar sesión</h2>
<%
HttpSession sesion = request.getSession();
if (request.getAttribute("logout") != null) { 
	if (request.getAttribute("logout").equals("true")) {
		sesion.setAttribute("isLogin", "false");
		%> <p>Saioa amaitu da!</p> <%
	}
} else {
	if (sesion.getAttribute("isLogin") == null
		||
		sesion.isNew()	
		||
		sesion.getAttribute("isLogin") == "false"){
		%> <p>Ez duzu saioa hasi!</p> <%
	} else {
		%> 
		<form method="post" action="<%=request.getContextPath()%>/UserCRUD">
			<input type="submit" name="action" value="logOut" /> 
		</form>
		<%
	}
}%>

<jsp:include page="../includes/sidebar.jsp"/>
<jsp:include page="../includes/footer.jsp"/>
