<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>

<jsp:include page="../includes/header.jsp"/>
<jsp:include page="../includes/menu.jsp"/>
<jsp:include page="../includes/content.jsp"/>

<h2>Borra un usuario</h2><br>

<form method="post" action="<%=request.getContextPath()%>/UserCRUDv2">
	<input type="text" id="name" name="name" />
	<input type="submit" name="action" value="deleteUser" />
</form>

<%if ( request.getAttribute("deleteUserMsg") != null ) { %>
	<h2><%=request.getAttribute("deleteUserMsg") %></h2>
<% } %>

<jsp:include page="../includes/sidebar.jsp"/>
<jsp:include page="../includes/footer.jsp"/>
