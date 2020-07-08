package br.com.fj21.controller;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fj21.dao.ContatoDAO;
import br.com.fj21.model.ContatoModel;

public class ListaContatoLogica implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		// recuperando conexao criada no filtro
		Connection connection = (Connection) req.getAttribute("conexao");
		ArrayList<ContatoModel> lista =  new ContatoDAO(connection).getLista();

		req.setAttribute("lista", lista);
		return "/WEB-INF/jsp/lista-contatos-taglib-2.0.jsp";
	}

}
