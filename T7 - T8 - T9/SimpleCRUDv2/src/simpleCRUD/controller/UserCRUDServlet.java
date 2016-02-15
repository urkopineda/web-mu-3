package simpleCRUD.controller;

import java.io.IOException;

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
		String next_page=PAGE_LIST;
		
		if (event != null){
			if (event.equals("addUser")) {
				addUser(request, response);
				next_page=PAGE_ADD;
			} else if (event.equals("logIn")) {
				checkUser(request, response);
				next_page=PAGE_CHECK;
			} else if (event.equals("logOut")) {
				closeSession(request, response);
				next_page=PAGE_OUT;
			} else if (event.equals("deleteUser")) {
				deleteUser(request, response);
				next_page=PAGE_DELETE;
			}
		} 
		Users users = new Users();
		users.setUsers(usersFacade.users().getUsers());
		users.setLength(users.getUsers().length);
		
		request.setAttribute("users", users);
		usersFacade.closeFacade();
		// Forward
		RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher(next_page);
		dispatcher.forward(request, response);
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void addUser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		User user = new User();
		boolean insertOk = false;

		if (request.getParameter("name") != null)
			user.setUserNick(request.getParameter("name"));
		if (request.getParameter("email") != null)
			user.setUserMail(request.getParameter("email"));
		if (request.getParameter("password") != null)
			user.setUserPasswd(request.getParameter("password"));

		UsersFacade usersFacade = new UsersFacade();
		insertOk = usersFacade.insertUser(user);
		usersFacade.closeFacade();

		if (insertOk) {

			request.setAttribute("addUserMsg", "Erabiltzailea ondo gorde da!!!");
		} else {

			request.setAttribute("addUserMsg", "Erabiltzailea ezin izan da gorde!!!");
		}
	}
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		User user = new User();
		boolean deleteOk = false;

		if (request.getParameter("name") != null)
			user.setUserNick(request.getParameter("name"));

		UsersFacade usersFacade = new UsersFacade();
		deleteOk = usersFacade.deleteUser(usersFacade.checkUserNoPass(user));
		usersFacade.closeFacade();
		if (deleteOk) {
			request.setAttribute("deleteUserMsg", "Erabiltzailea ondo ezabatu da!!!");
		} else {
			request.setAttribute("deleteUserMsg", "Erabiltzailea EZ da ondo ezabatu!!!");
		}
	}
	
	private void checkUser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		User user = new User();
		boolean checkOk = false;

		if (request.getParameter("name") != null)
			user.setUserNick(request.getParameter("name"));
		if (request.getParameter("password") != null)
			user.setUserPasswd(request.getParameter("password"));

		UsersFacade usersFacade = new UsersFacade();
		checkOk = usersFacade.checkUser(user);
		usersFacade.closeFacade();

		if (checkOk) {
			request.setAttribute("checkUserMsg", "Saioa hasi da!");
			request.setAttribute("login", "ok");
		} else {
			request.setAttribute("checkUserMsg", "Datuak okerrak dira!");
			request.setAttribute("login", "error");
		}
	}
	
	private void closeSession(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		request.setAttribute("logout", "true");
	}
	
	
}
