package simpleCRUD.domain.users.dao;

import java.util.ArrayList;

import simpleCRUD.domain.users.model.User;

public class UsersFacade {

	DaoUsers dao;

	public UsersFacade() {
		dao = new DaoUsersMysql();
		dao.connect();
	}

	public ArrayList<User> getAlumnos() {
		return dao.getAlumnos();
	}
	
	public boolean addAlumno(User user) {
		return dao.addAlumno(user);
	}
	
	public boolean deleteAlumno(User user) {
		return dao.deleteAlumno(user);
	}
	
	public void closeFacade() {
		dao.disconnect();
	}

	public ArrayList<User> getAlumnosByP(String provincia) {
		return dao.getAlumnosByP(provincia);
	}
	
}
