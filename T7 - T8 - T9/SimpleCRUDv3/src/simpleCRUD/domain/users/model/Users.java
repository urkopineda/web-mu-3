package simpleCRUD.domain.users.model;

import java.util.ArrayList;

public class Users {
	
	ArrayList<User> alumnos;
	
	public Users(ArrayList<User> alumnos) {
		this.alumnos = alumnos;
	}

	public ArrayList<User> getAlumnos() {
		return alumnos;
	}
	
	public User getAlumnoAt(int index) {
		return alumnos.get(index);
	}
	
	public int getSize() {
		if (alumnos == null) return 0;
		else return alumnos.size();
	}
	
}
