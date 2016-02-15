<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>
<%@ page import="simpleCRUD.domain.users.model.*" %>

<jsp:include page="../includes/header.jsp"/>
<jsp:include page="../includes/menu.jsp"/>
<jsp:include page="../includes/content.jsp"/>


<h2>Usuarios actuales</h2><br>
<table>
<%
Users users = (Users)request.getAttribute("users");
int i = 0;
for ( i = 0; i < users.getLength() ; i++){
	User user = users.getUser(i);
 %>
<tr>
	<td><%=user.getUserNick()%></td>
	<td><%=user.getUserMail()%></td>
	<td><%=user.getUserPasswd()%></td>
</tr>
<%}%>
</table>


<br></br> 
<jsp:include page="../includes/sidebar.jsp"/>
<jsp:include page="../includes/footer.jsp"/>



<table>

