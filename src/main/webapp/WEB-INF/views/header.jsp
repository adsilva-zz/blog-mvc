<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ler Livros Blog</title>
<link href="<c:url value="/resources/css/header.css" />"
	rel="stylesheet">
<!-- <spring:url value="/resources/css/header.css" var="header" /> -->
<!-- 	<spring:url value="/resources/js/jquery.1.10.2.min.js" var="jqueryJs" /> -->
<!-- 	<spring:url value="/resources/js/main.js" var="mainJs" /> -->

<link href="${header}" rel="stylesheet" />
<%--     <script src="${jqueryJs}"></script> --%>
<%--     <script src="${mainJs}"></script> --%>
</head>
<body>
	<!-- div para login logout -->
	<div>
		<c:if test="${user eq null }">
			<table class="top-bar">
				<tr>
					<td><a href="<c:url value="../usuario/logar"/>">Entrar</a></td>
					<td class="td-cadastrar"><a href="<c:url value="../usuario/cadastrarUsuario"/>">Cadastre-se</a>
					</td>
				</tr>
			</table>
		</c:if>
		<c:if test="${user ne null }">
			<table>
				<tr>
					<td>Olá ${user.nome }!</td>
					<td><a href="<c:url value="../usuario/sair"/>">Sair</a></td>
				</tr>
			</table>
		</c:if>
	</div>

	<!-- 	div foto do Blog -->
	<div class="div-img-logo">
		<img class="img-logo" src="https://images.vexels.com/media/users/3/140908/isolated/preview/bdc30bbe3c022a11e2d7fd0e642c61ae--cone-do-livro-aberto-by-vexels.png" >
	</div>

	<!-- div menu principal -->
	<div>
		<c:if test="${user.tipo eq 'ADMINISTRADOR' }">
			<table>
				<tr>
					<td><a href="<c:url value="../postagem/listarPost"/>">Gerenciar
							Conteúdo</a></td>
					<td><a href="<c:url value="../usuario/listarUsuario"/>">Gerenciar
							Usuarios</a></td>
				</tr>
			</table>
		</c:if>
		<c:if test="${user.tipo eq 'CADASTRADO' || user.tipo eq null}">
			<table>
				<tr>
					<td><a href="<c:url value="../postagem/listarPost"/>">Resenhas</a></td>
				</tr>
			</table>
		</c:if>
	</div>
</body>
</html>