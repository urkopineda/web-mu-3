<div id="menu">
	<table>
		<tr>
			<td>
				<ul>
					<li><a href="<%=request.getContextPath()%>/index.jsp"">Home</a></li>
					<li><a href="<%=request.getContextPath()%>/pages/addUser.jsp">Agregar un usuario</a></li>
					<li><a href="<%=request.getContextPath()%>/UserCRUD">Ver usuarios</a></li>
					<li><a href="#">About</a></li>
					<li><a href="#">Links</a></li>
					<li><a href="#">Contact</a></li>
				</ul>
			</td>
			<td align="right">
			<font size="4">
				<%
					HttpSession sesion = request.getSession();
					if (sesion.getAttribute("isLogin") == null
						||
						sesion.isNew()	
						||
						sesion.getAttribute("isLogin") == "false"){
				%>	
						<a href="<%=request.getContextPath()%>/pages//login.jsp">Login</a>	
				<%	}else{ %>
						<a href="<%=request.getContextPath()%>/pages//logout.jsp">Logout</a>	
				<% 	} %>
			</font>	
			</td>
		</tr>
			
	</table>	
	
	</div>
