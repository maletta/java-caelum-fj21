package br.com.fj21.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fj21.dao.ContatoDAO;
import br.com.fj21.model.ContatoModel;

public class ListaContatoLogica implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		List<ContatoModel> lista =  new ContatoDAO().getLista();
		System.out.println(lista);
		req.setAttribute("lista", lista);
		return "/WEB-INF/jsp/lista-contatos-taglib-2.0.jsp";
	}

}
