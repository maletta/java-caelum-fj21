<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="br.com.fj21.dao.ContatoDAO, 
br.com.fj21.model.ContatoModel,
br.com.fj21.dao.ConnectionFactory,
java.sql.Connection,
 java.util.List,
java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista contatos</title>
</head>
<body>

	<table>
		<%
			Connection connection = new ConnectionFactory().getConnection();
		ContatoDAO dao = new ContatoDAO(connection);
		List<ContatoModel> contatos = dao.getLista();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String dataNasc = null;
		for (ContatoModel contato : contatos) {
			dataNasc = sdf.format(contato.getDataNascimento().getTime());
		%>
		<tr>
			<td><%=contato.getNome()%></td>
			<td><%=contato.getEmail()%></td>
			<td><%=contato.getEndereco()%></td>
			<td><%=dataNasc%></td>
		</tr>
		<%
			}
		%>
	</table>

</body>
</html>