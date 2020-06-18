<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar com taglib</title>
</head>
<body>

	<!-- cria o DAO -->
	<jsp:useBean id="contatoDAO" class="br.com.fj21.dao.ContatoDAO" />
	<%
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	%>

	<c:forEach var="contato" items="${contatoDAO.lista}">

		${contato.nome}, ${contato.email},
        ${contato.endereco}, ${contato.dataNascimento} 
	</c:forEach>

	</br>
	</br>
	</br>

	<table border="1">
		<thead>
			<tr>
				<th>Contador</th>
				<th>Nome</th>
				<th>Email</th>
			</tr>
		</thead>
		<!-- percorre contatos montando as linhas da tabela -->
		<tbody>
			<c:forEach var="contato" items="${contatoDAO.lista}" varStatus="id">
				<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff' }">
					<td>${id.count}</td>
					<td>${contato.nome}</td>
					<td>
						<c:choose>
						<c:when test="${not empty contato.email }">
							<a href="mailto:${contato.email }">${contato.email }</a>
						</c:when>
						<c:otherwise>
							E-mail não informado
						</c:otherwise>
					</c:choose>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>