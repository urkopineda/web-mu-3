package simpleCRUD.domain.users.dao;

import simpleCRUD.domain.users.model.User;
import simpleCRUD.domain.users.model.Users;

public class UsersFacade {

	DaoUsers dao;

	public UsersFacade() {

		dao = new DaoUsersMysql();
		dao.connect();
	}

	public boolean insertUser(User user) {

		return dao.insertUser(user);
	}
	
	public boolean checkUser(User user) {

		return dao.checkUser(user);
	}

	public boolean deleteUser(int id) {

		return dao.deleteUser(id);
	}

	
	public Users users() {

		return dao.users();
	}

		
	public void closeFacade() {

		dao.disconnect();
	}
}
