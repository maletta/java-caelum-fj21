package br.com.fj21.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Logica {
	
	 String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception;

}
