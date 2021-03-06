package br.com.fj21.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.fj21.model.ContatoModel;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ContatoDAO {

	
	private Connection connection;
	
	// connection será injetada neste objeto
	// inversão de controle, esta classe não controla mais a instanciação das conexões
	public ContatoDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void adiciona(ContatoModel contato) {
		
		String sql = "Insert into contatos (nome,email,endereco,dataNascimento) values (?,?,?,?)";

		try {
			PreparedStatement stm = this.connection.prepareStatement(sql);
			stm.setString(1, contato.getNome());
			stm.setString(2, contato.getEmail());
			stm.setString(3, contato.getEndereco());
			stm.setDate(4, new java.sql.Date(contato.getDataNascimento().getTimeInMillis()));

			// executa
			stm.execute();
			stm.close();
			this.connection.close();
			System.out.println("Salvou");
		} catch (Exception e) {
			System.out.println("Não Salvou");
		}
	}

	public ArrayList getLista() {
		String consultaSQL = "Select * from contatos";
		ArrayList<ContatoModel> lista = null;
		try {
			PreparedStatement stm = this.connection.prepareStatement(consultaSQL);
			ResultSet resultado = stm.executeQuery();
			lista = new ArrayList();
			while (resultado.next()) {
				ContatoModel contato = new ContatoModel();
				contato.setId(resultado.getLong("id"));
				contato.setNome(resultado.getString("nome"));
				contato.setEmail(resultado.getString("email"));
				contato.setEndereco(resultado.getString("endereco"));

				// Define o formato que vou receber em String
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				// String do banco que vem yyyy-MM-dd"
				String dataNascimentoString = resultado.getString("dataNascimento");
				try {
					// Formata a data recebida do banco em um Objeto Date (yyyy-MM-dd")
					Date dataNascimentoDate = (Date) sdf.parse(dataNascimentoString);
					// Define um objeto Calendar com a data de agora
					Calendar calendar = Calendar.getInstance();
					// Atribui uma nova data ao Calendar
					calendar.setTime(dataNascimentoDate);
					contato.setDataNascimento(calendar);
				} catch (ParseException e) {
					System.out.println("Problema ao formatar a data no ContatoDAO");
					e.printStackTrace();
				}
				lista.add(contato);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao retornar uma lista de objetos do banco no ContatoDAO");
		}
		System.out.println("lista retornada");
		return lista;
	}

	public void altera(ContatoModel contato) {
		
		String sql = "update contatos set nome=?, email=?, endereco=?," + "dataNascimento=? where id=?";
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new java.sql.Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void remove(ContatoModel contato) {
	    try {
	        PreparedStatement stmt = this.connection.prepareStatement("delete " +
	                "from contatos where id=?");
	        stmt.setLong(1, contato.getId());
	        stmt.execute();
	        stmt.close();
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}

	public String retorno() {
		return "Malettão";
	}
}