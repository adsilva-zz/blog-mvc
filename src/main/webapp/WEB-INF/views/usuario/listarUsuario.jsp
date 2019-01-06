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
	<h1>Lista de Usu�rios</h1>
	<div>
		<table>
			<c:forEach items="${usuarios}" var="usuario">
				<tr>
					<td>${usuario.apelido}</td>

					<td>
						<form action="./excluirUsuario?id=${usuario.id}" method="post">
							<input type="submit" value="Excluir">
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>