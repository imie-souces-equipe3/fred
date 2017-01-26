package fr.imie.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public interface IConnexionManagement {

	void closeJDBCResources(Connection connection, Statement statement, ResultSet resultSet);

	Connection initConnexion() throws SQLException;

}