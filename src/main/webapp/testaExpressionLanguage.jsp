<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	Digite sua idade e pressione o botão:
	<br />

	<form action="testaExpressionLanguage.jsp">
		Idade: <input type="text" name="idade" /> <input type="submit" />
	</form>

	

	A idade informada é ${param.idade}
</body>
</html>