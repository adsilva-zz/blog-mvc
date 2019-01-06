<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ler Livros Blog</title>
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div>
		<h1>Resenhas</h1>
	</div>
	<div>
		<c:if test="${user.tipo eq 'ADMINISTRADOR'}">
			<table>
				<tr>
					<td>
						<form action="./cadastrarPost" method="post">
							<input type="submit" value="Nova Resenha">
						</form>
					</td>
				</tr>
			</table>
		</c:if>
	</div>
	<div>
		<table>
			<c:forEach items="${postagens}" var="postagem">
				<tr>
					<td><a href='<c:url value="./showPost?id=${postagem.id}"/>'>${postagem.titulo}</a>
					</td>
					<c:if test="${user.tipo eq 'ADMINISTRADOR'}">
						<c:if test="${postagem.listaComentarios.size()==0  }">
							<td>
								<form action="./editarPost?id=${postagem.id}" method="post">
									<input type="submit" value="Editar">
								</form>
							</td>
						</c:if>

						<td>
							<form action="./excluirPost?id=${postagem.id}" method="post">
								<input type="submit" value="Excluir">
							</form>
						</td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>