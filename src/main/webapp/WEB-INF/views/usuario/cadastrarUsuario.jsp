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
	<h1>Cadastro de Usuários</h1>
	<div>
		<form action="./salvarUsuario" method="post">
			<div>
				<label for="nome">Nome:</label> <input type="text" id="nome"
					name="nome">
			</div>
			<div>
				<label for="email">E-mail:</label> <input id="email" name="email"
					type="text">
			</div>
			<div>
				<label for="senha">Senha:</label> <input id="senha" name="senha"
					type="password">
			</div>
			<div>
				<label for="apelido">Apelido:</label> <input id="apelido"
					name="apelido" type="text">
			</div>
			<div>
				<input type="submit" value="Salvar">
			</div>
		</form>
	</div>
</body>
</html>