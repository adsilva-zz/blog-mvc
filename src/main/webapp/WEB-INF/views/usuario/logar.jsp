<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ler Livros Blog</title>
</head>
<body>
	<%@ include file="../header.jsp"%>
	<h1>Logar</h1>
	<div>
		<form action="./autenticar" method="post">
			<div>
				<label for="apelido">Apelido:</label> <input name="apelido"
					id="apelido" type="text">
			</div>
			<div>
				<label for="senha">Senha:</label> <input name="senha"
					type="password" id="senha">
			</div>
			<div>
				<input type="submit" value="Entrar">
			</div>
		</form>
	</div>
</body>
</html>