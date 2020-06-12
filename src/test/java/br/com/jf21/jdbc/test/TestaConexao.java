package br.com.jf21.jdbc.test;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.fj21.dao.ConnectionFactory;

public class TestaConexao {

	public static void main(String args[]) {
		Connection connection = new ConnectionFactory().getConnection();
		System.out.println("Conex�o aberta");
		try {
			connection.close();
			System.out.println("Conex�o fechada");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
