package br.com.fj21.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;

import java.sql.Connection;
import br.com.fj21.dao.ContatoDAO;
import br.com.fj21.dao.ConnectionFactory;

@WebFilter(filterName = "filtroConexao", urlPatterns = {"/*"})
public class FiltroConexao implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		Connection connection = new ConnectionFactory().getConnection();
		// injetando conexao ao banco na request
		request.setAttribute("conexao", connection);
		
		chain.doFilter(request, response);
		
		
	}

	
}
