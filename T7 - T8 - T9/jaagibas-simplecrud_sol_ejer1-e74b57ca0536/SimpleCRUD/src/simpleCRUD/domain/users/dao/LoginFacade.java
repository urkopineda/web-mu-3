package simpleCRUD.domain.users.dao;

public class LoginFacade {
	DaoLogin login = null;
	
	public LoginFacade(){
		login = new DaoLoginProperties();
	
	}
	public boolean exists(String username , String password){
		return login.exists(username, password);
	}
}
