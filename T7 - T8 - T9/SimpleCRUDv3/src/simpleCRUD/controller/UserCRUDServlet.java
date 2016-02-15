package simpleCRUD.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import simpleCRUD.domain.users.dao.UsersFacade;
import simpleCRUD.domain.users.model.User;
import simpleCRUD.domain.users.model.Users;

/**
 * Servlet implementation class UserCRUDServlet
 */
@WebServlet("/UserCRUDv2")
public class UserCRUDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PAGE_ADD = "/pages/addUser.jsp";
	private static final String PAGE_LIST = "/pages/users.jsp";
	private static final String PAGE_CHECK = "/pages/login.jsp";
	private static final String PAGE_OUT = "/pages/logout.jsp";
	private static final String PAGE_DELETE = "/pages/deleteUser.jsp";
	private static final String PAGE_MODIFY = "/pages/modifyUser.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCRUDServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String event = request.getParameter("action");
		UsersFacade usersFacade = new UsersFacade();
		String next_page = PAGE_LIST;
		if (event != null){
			if (event.equals("addUser")) {
				addAlumno(request, response);
				next_page=PAGE_ADD;
			} else if (event.equals("deleteUser")) {
				deleteAlumno(request, response);
				next_page=PAGE_DELETE;
			} else if (event.equals("filtrarPorProvincia")) {
				getAlumnosByP(request, response);
				next_page=PAGE_LIST;
			}
		} else {
			request.setAttribute("correct", "true");
			Users users = new Users(usersFacade.getAlumnos());
			request.setAttribute("listAlumnos", users);
		}
		usersFacade.closeFacade();
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(next_page);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void getAlumnosByP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String provincia = null;
		if (request.getParameter("provincia") != null) {
			provincia = request.getParameter("provincia");
		}
		UsersFacade usersFacade = new UsersFacade();
		Users alumnos = new Users(usersFacade.getAlumnosByP(provincia));
		usersFacade.closeFacade();
		request.setAttribute("listAlumnos", alumnos);
		request.setAttribute("correct", "true");
	}
	
	private void addAlumno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User(0);
		if (request.getParameter("alumnoName") != null) {
			user.setuNombre(request.getParameter("alumnoName"));
		}
		if (request.getParameter("alumnoApellido") != null) {
			user.setuApellido(request.getParameter("alumnoApellido"));
		}
		if (request.getParameter("alumnoProvincia") != null) {
			user.setuProvincia(request.getParameter("alumnoProvincia"));
		}
		if (request.getParameter("alumnoEmail") != null) {
			user.setuEmail(request.getParameter("alumnoEmail"));
		}
		UsersFacade usersFacade = new UsersFacade();
		boolean s = usersFacade.addAlumno(user);
		usersFacade.closeFacade();
		if (s) request.setAttribute("correct", "Alumnos introducidos!");
		else request.setAttribute("correct", "ERROR!");
	}
	
	private void deleteAlumno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = null;
		if (request.getParameter("alumnoId") != null) {
			user = new User(Integer.parseInt(request.getParameter("alumnoId")));
		}
		UsersFacade usersFacade = new UsersFacade();
		boolean s = usersFacade.deleteAlumno(user);
		usersFacade.closeFacade();
		if (s) request.setAttribute("correct", "Alumno borrado!");
		else request.setAttribute("correct", "ERROR!");
	}
	
	private void closeSession(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		request.setAttribute("logout", "true");
	}
	
}
