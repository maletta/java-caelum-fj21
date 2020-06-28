package br.com.fj21.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrimeiraLogica implements Logica{

	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		// http://localhost:8080/fj21/mvc?logica=PrimeiraLogica
		return "/WEB-INF/jsp/PrimeiraLogica.jsp";
	}
	
}
