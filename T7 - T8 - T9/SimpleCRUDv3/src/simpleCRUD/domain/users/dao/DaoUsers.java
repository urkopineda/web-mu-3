package simpleCRUD.domain.users.dao;

import java.util.ArrayList;

import simpleCRUD.domain.users.model.User;

public interface DaoUsers {

	public void connect();

	public void disconnect();
	
	public ArrayList<User> getAlumnos();
	
	public boolean addAlumno(User user);
	
	public boolean deleteAlumno(User user);

	public ArrayList<User> getAlumnosByP(String provincia);
	
}
