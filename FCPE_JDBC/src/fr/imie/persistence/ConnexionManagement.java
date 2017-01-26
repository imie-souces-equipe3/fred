package fr.imie.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnexionManagement implements IConnexionManagement {

	public ConnexionManagement() {
		super();
	}

	@Override
	public void closeJDBCResources(Connection connection, Statement statement, ResultSet resultSet) {
		try {
			if (resultSet != null && !resultSet.isClosed()) {
				resultSet.close();
			}
			if (statement != null && !statement.isClosed()) {
				statement.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Connection initConnexion() throws SQLException {
		Connection connection;
		connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/fcpe", "postgres", "postgres");
		return connection;
	}

}