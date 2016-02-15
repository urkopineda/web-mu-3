package simpleCRUD.domain.users.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import simpleCRUD.domain.users.model.User;
import simpleCRUD.domain.users.model.Users;

public class DaoUsersMysql implements DaoUsers {

	Connection connection = null;

	Statement statement = null;

	String serverName = "localhost";

	String dataBaseName = "erabiltzaileak";

	String url = "jdbc:mysql://";

	String username = "root";

	String password = "root";

	String connectionString = null;

	public DaoUsersMysql() {

		this.connectionString = url + serverName + "/" + dataBaseName;
	}

	@Override
	public void connect() {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			// Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(connectionString,
					username, password);
			statement = connection.createStatement();
		} catch (ClassNotFoundException e) {

			System.out.println("Connection Driver Error");
		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("Could Not Connect to DB ");
		}
	}

	@Override
	public void disconnect() {

		try {

			if (statement != null) {

				statement.clearWarnings();
				statement.close();
			}

			if (connection != null) {

				connection.clearWarnings();
				connection.close();
			}
		} catch (SQLException e) {

			System.out.println("Error disconnecting");
		}
	}

	@Override
	public boolean deleteUser(int id) {
		
		boolean ret = false;
		String sqlQuery = "DELETE FROM erabiltzaileak.erabiltzaileak WHERE uId = " + id + ";";

		try {
			statement.executeUpdate(sqlQuery);
			ret = true;
		} catch (SQLException e) {
			System.out.println(sqlQuery);
			e.printStackTrace();
			System.out.println("Error SQL Delete");
		}

		return ret;
	}

	@Override
	public boolean insertUser(User user) {

		boolean ret = false;
		String sqlQuery = "INSERT INTO erabiltzaileak.erabiltzaileak (uNick, uEmail, uPassword) "
				+ "VALUES('" + user.getUserNick() + "', '" + user.getUserMail()
				+ "', '" + user.getUserPasswd() + "');";

		try {

			statement.executeUpdate(sqlQuery);
			ret = true;
		} catch (SQLException e) {

			System.out.println(sqlQuery);
			e.printStackTrace();
			System.out.println("Error SQL Insert");
		}

		return ret;
	}

	
	@Override
	public Users users() {

		User[] user;
		Users ret = new Users();
		ArrayList<User> users = new ArrayList<User>();
		String sqlQuery = "SELECT uId, uNick, uEmail, uPassword "
				+ "FROM erabiltzaileak.erabiltzaileak ORDER BY uNick, uId;";

		ResultSet rs = null;

		try {

			Statement stm = connection.createStatement();
			rs = stm.executeQuery(sqlQuery);

			while (rs.next()) {

				User userAux = new User();
				userAux.setUserId(rs.getInt("uId"));
				userAux.setUserNick(rs.getString("uNick"));
				userAux.setUserMail(rs.getString("uEmail"));
				userAux.setUserPasswd(rs.getString("uPassword"));
				
				users.add(userAux);
			}
		} catch (SQLException e) {

			System.out.println(sqlQuery);
			e.printStackTrace();
			System.out.println("Error SQL Select");
		}

		user = users.toArray(new User[users.size()]);
		ret.setUsers(user);

		return ret;
	}

	@Override
	public boolean checkUser(User user) {
		String sqlQuery = "SELECT uNick, uPassword "
						+ "FROM "+dataBaseName+" "
						+ "WHERE (uNick = '" + user.getUserNick() + "') AND (uPassword = '" + user.getUserPasswd() + "');";
		ResultSet rs = null;
		Statement stm = null;
		try {
			stm = connection.createStatement();
			rs = stm.executeQuery(sqlQuery);
			if (!rs.next()) return false;
			else return true;
		} catch (SQLException e1) {
			System.out.println(sqlQuery);
			e1.printStackTrace();
			System.out.println("Error SQL Select");
		} return false;
	}
	
	public int checkUserNoPass(User user) {
		String sqlQuery = "SELECT uId "
						+ "FROM "+dataBaseName+" "
						+ "WHERE (uNick = '" + user.getUserNick() + "');";
		ResultSet rs = null;
		Statement stm = null;
		try {
			stm = connection.createStatement();
			rs = stm.executeQuery(sqlQuery);
			if (!rs.next()) return -1;
			else return rs.getInt("uId");
		} catch (SQLException e1) {
			System.out.println(sqlQuery);
			e1.printStackTrace();
			System.out.println("Error SQL Select");
		} return -1;
	}

}
