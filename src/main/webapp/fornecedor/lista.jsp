<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.List, com.stolk.alecsandro.contas.modelo.Fornecedor"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/fornecedores/novo" var="linkServletNovoFornecedor" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>### Lista de fornecedores ###</title>
</head>
<body>

	<c:if test="${ not empty fornecedor }">
		Fornecedor ${ fornecedor } cadastrado com sucesso!
	</c:if>

    <br />
    <form action="${linkServletNovoFornecedor}" method="get">
        <button type="submit">Cadastrar</button>
    </form>
    <br />

	Lista de fornecedores:
	<br />

	<ol>
		<c:forEach items="${fornecedores}" var="fornecedor">
			<li>${fornecedor.documento} | ${fornecedor.nome} |
					<a href="/contas/fornecedores/mostra?id=${fornecedor.id}">Editar</a>
					<a href="/contas/fornecedores/remove?id=${fornecedor.id}">Remover</a>
			</li>
		</c:forEach>
	</ol>

</body>
</html>