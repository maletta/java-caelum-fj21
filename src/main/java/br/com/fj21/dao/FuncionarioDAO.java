package br.com.fj21.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.fj21.model.Funcionario;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class FuncionarioDAO {

	public void insere(Funcionario funcionario) {
		Connection con = new ConnectionFactory().getConnection();
		String sql = "Insert into funcionarios (cpf, nome, sobrenome, rg) values (?,?,?,?)";

		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setLong(1, funcionario.getCpf());
			stm.setString(2, funcionario.getNome());
			stm.setString(3, funcionario.getSobrenome());
			stm.setLong(4, funcionario.getRg());

			// executa
			stm.execute();
			stm.close();
			con.close();
			System.out.println("Salvou");
		} catch (Exception e) {
			System.out.println("Não Salvou");
		}
	}

	public ArrayList<Funcionario> getLista() {
		Connection con = new ConnectionFactory().getConnection();
		String consultaSQL = "select * from funcionarios";
		ArrayList<Funcionario> lista = null;
		try {
			PreparedStatement stm = con.prepareStatement(consultaSQL);
			ResultSet resultado = stm.executeQuery();
			lista = new ArrayList<Funcionario>();
			while (resultado.next()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setCpf(resultado.getLong("cpf"));
				funcionario.setNome(resultado.getString("nome"));
				funcionario.setSobrenome(resultado.getString("sobrenome"));
				funcionario.setRg(resultado.getLong("rg"));
				lista.add(funcionario);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao retornar uma lista de objetos do banco no FuncionarioDAO");
		}
		return lista;
	}

	public void altera(Funcionario funcionario) {
		Connection con = new ConnectionFactory().getConnection();
		
		String sql = "update funcionarios set  cpf=?, nome=?, sobrenome=?, rg=? where cpf=? and rg=? ";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setLong(1, funcionario.getCpf());
			stm.setString(2, funcionario.getNome());
			stm.setString(3, funcionario.getSobrenome());
			stm.setLong(4, funcionario.getRg());
			stm.setLong(5, funcionario.getCpf());
			stm.setLong(6, funcionario.getRg());
			stm.execute();
			stm.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void remove(Funcionario funcionario) {
		Connection con = new ConnectionFactory().getConnection();
	    try {
	        PreparedStatement stm = con.prepareStatement("delete " +
	                "from funcionarios where cpf=? and rg=?");
	        stm.setLong(1, funcionario.getCpf());
			stm.setLong(2, funcionario.getRg());
	        stm.execute();
	        stm.close();
	        
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}

	public String retorno() {
		return "Malettão";
	}
}