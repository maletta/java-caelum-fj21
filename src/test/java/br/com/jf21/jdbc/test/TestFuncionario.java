package br.com.jf21.jdbc.test;

import br.com.fj21.model.Funcionario;

import java.util.List;

import br.com.fj21.dao.FuncionarioDAO;

public class TestFuncionario {
	public static void main(String args[]) {

		// testInsere(11111111111L, "um um", "hmmmmm", 111111111);
		// testInsere(22222222222L, "dois dois", "doisdois", 222222222);
		// testAltera(22222222222L, "três três", "trestres", 222222222);
		// testRemove(22222222222L, 222222222);
		testGetLista();
	}

	public static void testInsere(Long cpf, String nome, String sobrenome, int rg) {
		// Criando funcionario
		Funcionario funcionario = new Funcionario();
		funcionario.setCpf(cpf);
		funcionario.setNome(nome);
		funcionario.setSobrenome(sobrenome);
		funcionario.setRg(rg);

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

		funcionarioDAO.insere(funcionario);
		System.out.println("Test inserir");
	}

	public static void testGetLista() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		List<Funcionario> lista = funcionarioDAO.getLista();
		for (Funcionario f : lista) {
			System.out.println(f);
		}

	}

	public static void testAltera(Long cpf, String nome, String sobrenome, int rg) {
		// Criando funcionario
		Funcionario funcionario = new Funcionario();
		funcionario.setCpf(cpf);
		funcionario.setNome(nome);
		funcionario.setSobrenome(sobrenome);
		funcionario.setRg(rg);

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

		funcionarioDAO.altera(funcionario);
		;
		System.out.println("Test alterar");
	}

	public static void testRemove(Long cpf, int rg) {
		// Criando funcionario
		Funcionario funcionario = new Funcionario();
		funcionario.setCpf(cpf);
		funcionario.setRg(rg);

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

		funcionarioDAO.remove(funcionario);
		;
		System.out.println("Test remover");

	}
}
