package br.com.fj21.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/sistema" })
public class SistemaTodoServlet extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nomeDaClasse = "br.com.fj21.controller."+ req.getParameter("logica");
		

		try {
			Class<?> classe = Class.forName(nomeDaClasse);
			Logica logica = (Logica) classe.newInstance();
			
			//Recebe o String após a execução da lógica
			String pagina = logica.executa(req, resp);
			
			//Faz o forward para página JSP
			req.getRequestDispatcher(pagina).forward(req, resp);
		} catch (Exception  e) {
			throw new ServletException(
					"A lógica de negócio causou uma exceção", e);
		}
		
		
	}

}
