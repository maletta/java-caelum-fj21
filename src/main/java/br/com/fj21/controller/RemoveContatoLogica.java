package br.com.fj21.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fj21.dao.ContatoDAO;
import br.com.fj21.model.ContatoModel;

@WebServlet(urlPatterns = { "/remover" })
public class RemoveContatoLogica extends HttpServlet implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {

		long id = Long.parseLong(req.getParameter("id"));
		ContatoModel contato = new ContatoModel();
		contato.setId(id);
		ContatoDAO dao = new ContatoDAO();
		dao.remove(contato);

		System.out.println("Removeu contato");

		return "lista-contatos-taglib.jsp";
	}

}