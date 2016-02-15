package simpleCRUD.domain.users.dao;

import simpleCRUD.domain.users.model.User;
import simpleCRUD.domain.users.model.Users;

public interface DaoUsers {

	public void connect();

	public void disconnect();

	public boolean insertUser(User user);
	
	public boolean checkUser(User user);

	public boolean deleteUser(int id);

	public Users users();
	
	public int checkUserNoPass(User user);

	
}
