package simpleCRUD.domain.users.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DaoLoginProperties implements DaoLogin {
	
	private String fileName = "config.properties";
	private Properties prop = null;
	
	public DaoLoginProperties() {
		prop = new Properties();
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		try {
			
			prop.load(classLoader.getResourceAsStream(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean exists(String username , String password){
		String name;
		String pass;
		name = prop.getProperty("name");
		pass = prop.getProperty("password");
		boolean ret = false;
		if ( name.equals(username) && (pass.equals(pass)) ){
			ret = true;
		}
		
		return ret;
	}
}
