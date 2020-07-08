package br.com.fj21.controller;



import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fj21.dao.ContatoDAO;
import br.com.fj21.model.ContatoModel;

@WebServlet(urlPatterns= {"/adicionar"})
public class AdicionaContatoServlet extends HttpServlet implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		
		// http://localhost:8080/fj21/mvc?logica=PrimeiraLogica
		String nome = req.getParameter("nome");
		String endereco = req.getParameter("endereco");
		String email = req.getParameter("email");
		String dataEmTexto = req.getParameter("dataNascimento");
		Calendar dataNascimento = null;

		// fazendo a conversão da data

		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
		} catch (ParseException e) {
			System.out.println("Não Adicionou contato");
			e.printStackTrace();
			return "lista-contatos-taglib.jsp"; // para a execução do método
		}

		// monta objeto contato
		ContatoModel contato = new ContatoModel();
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setDataNascimento(dataNascimento);

		// salva contato
		// recuperando conexao criada no filtro
		ContatoDAO dao = new ContatoDAO((Connection) req.getAttribute("conexao"));
		dao.adiciona(contato);
		
		System.out.println("Adicionou contato");
		
		return "lista-contatos-taglib.jsp";
	}
	
}
