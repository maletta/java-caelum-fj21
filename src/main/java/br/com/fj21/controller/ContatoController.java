package br.com.fj21.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.sql.Connection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fj21.dao.ContatoDAO;
import br.com.fj21.model.ContatoModel;


//name = nome da servlet
//urlPatterns = mapeamento de umas ou mais urls disponíveis para acesso
//value = mapeamento único url disponível para acesso
@WebServlet(name = "contato", urlPatterns = {"/contato", "/contact" })
public class ContatoController extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {
        super.init(config);
        log("Iniciando a servlet");
        System.out.println("Iniciando contato servlet");
    }

    public void destroy() {
        super.destroy();
        log("Destruindo a servlet");
        System.out.println("Destruindo contato servlet");
    }
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Servlet contato");
		PrintWriter out = resp.getWriter();

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
			System.out.println("Deu ruim");
			e.printStackTrace();
			return; // para a execução do método
		}

		// monta objeto contato
		ContatoModel contato = new ContatoModel();
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setDataNascimento(dataNascimento);

		// salva contato
		// recuperar conexao criada no filtro
		ContatoDAO dao = new ContatoDAO((Connection) req.getAttribute("conexao"));
		dao.adiciona(contato);

		// imprime o nome do contato que foi adicionado
		//System.out.println(dataEmTexto);
		//System.out.println(dataNascimento);
		out.print("adicionado com sucesso");
	}

}
