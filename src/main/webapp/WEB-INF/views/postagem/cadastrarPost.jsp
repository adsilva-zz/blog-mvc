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
	<div>
		<h1>Cadastrar Resenha</h1>
	</div>
	<div>
		<form method="post" action="./salvarPost">
			<div>
				<label for="titulo">Título:</label> <input type="text" name="titulo"
					id="titulo">
			</div>
			<div>
				<label for="conteudo">Conteudo:</label>
				<textarea rows="30" cols="50" name="conteudo" id="conteudo"></textarea>
			</div>

			<div>
				<input type="submit" value="Salvar">
			</div>
		</form>
	</div>
</body>
</html>