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
		<h1>${post.titulo}</h1>
		<p>${post.conteudo}</p>
		<p>${post.dataCriacao}</p>
	</div>
	<div>
		<form action="../comentario/salvarComentario" method="post">
			<input type="hidden" name="usuarioId" value="${user.id}" /> <input
				type="hidden" name="postId" value="${post.id}" /> <input
				type="hidden" name="deletar" value="0" /> <input name="comentario"
				type="text" placeholder="Digite um comentário"> <input
				type="submit" value="Salvar">
		</form>
	</div>
	<div>${mensagem }</div>
	<div>
		<table>
			<c:if test="${qnt > 0  }">
				<c:forEach items="${post.listaComentarios}" var="comentario">
					<tr>
						<td>${comentario.texto}</td>
						<td><c:if test="${user.tipo eq 'ADMINISTRADOR'  }">
								<form action="../comentario/salvarComentario" method="post">
									<input type="hidden" name="usuarioId" value="${user.id}" /> <input
										type="hidden" name="postId" value="${post.id}" /> <input
										type="hidden" name="idComentario" value="${comentario.id}" />
									<input type="hidden" name="deletar" value="1" /> <input
										type="submit" value="Excluir">
								</form>
							</c:if></td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</div>
</body>
</html>