package br.com.fj21.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ServiceLoader;

public class ConnectionFactory {

	public Connection getConnection() {
		Connection connection = null;
		try {
			
			//carrega a classe 
			//ServiceLoader.load(org.postgresql.Driver.class);

			Class.forName("org.postgresql.Driver");
			String settings = "jdbc:postgresql://localhost:5432/fj21";
			String user = "postgres";
			String password = "postgres";

			connection = DriverManager.getConnection(settings, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			 e.printStackTrace();
			 //relançando a exceção para não ficarmos acoplados a API JDBC
			 throw new RuntimeException(e);
		}

		return connection;
	}

}
