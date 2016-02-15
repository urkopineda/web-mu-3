package simpleCRUD.domain.users.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import simpleCRUD.domain.users.model.User;

public class DaoUsersMysql implements DaoUsers {

	Connection connection = null;
	Statement statement = null;
	String serverName = "localhost";
	String dataBaseName = "IKASLEAK";
	String tableName = "IKASLEAK";
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
			connection = DriverManager.getConnection(connectionString, username, password);
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
	public ArrayList<User> getAlumnos() {
		String sqlQuery = "SELECT * FROM "+tableName;
		Statement stm;
		ResultSet rs;
		ArrayList<User> alumnos = null;
		try {
			stm = connection.createStatement();
			rs = stm.executeQuery(sqlQuery);
			alumnos = new ArrayList<>();
			while (rs.next()) {
				User temp = new User(rs.getInt("uId"));
				temp.setuNombre(rs.getString("uNombre"));
				temp.setuApellido(rs.getString("uApellido"));
				temp.setuProvincia(rs.getString("uProvincia"));
				temp.setuEmail(rs.getString("uEmail"));
				alumnos.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alumnos;
	}
	
	@Override
	public boolean addAlumno(User user) {
		try {
			PreparedStatement pstm = connection.prepareStatement("INSERT INTO IKASLEAK (uNombre, uApellido, uProvincia, uEmail) VALUES (?, ?, ?, ?)");
			pstm.setString(1, user.getuNombre());
			pstm.setString(2, user.getuApellido());
			pstm.setString(3, user.getuProvincia());
			pstm.setString(4, user.getuEmail());
			pstm.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean deleteAlumno(User user) {
		try {
			PreparedStatement pstm = connection.prepareStatement("DELETE FROM IKASLEAK WHERE uId = ?");
			pstm.setInt(1, user.getuId());
			pstm.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<User> getAlumnosByP(String provincia) {
		String sqlQuery = "SELECT * FROM "+tableName+" WHERE uProvincia = '"+provincia+"';";
		Statement stm;
		ResultSet rs;
		ArrayList<User> alumnos = null;
		try {
			stm = connection.createStatement();
			rs = stm.executeQuery(sqlQuery);
			alumnos = new ArrayList<>();
			while (rs.next()) {
				User temp = new User(rs.getInt("uId"));
				temp.setuNombre(rs.getString("uNombre"));
				temp.setuApellido(rs.getString("uApellido"));
				temp.setuProvincia(rs.getString("uProvincia"));
				temp.setuEmail(rs.getString("uEmail"));
				alumnos.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alumnos;
	}

}
