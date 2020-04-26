<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.List, com.stolk.alecsandro.contas.modelo.Lancamento"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/lancamentos/novo" var="linkServletNovoLancamento" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>### Lista de lançamentos ###</title>
</head>
<body>

	<c:if test="${ not empty lancamento }">
		Lançamento ${ lancamento } cadastrado com sucesso!
	</c:if>

    <br />
    <form action="${linkServletNovoLancamento}" method="get">
        <button type="submit">Cadastrar</button>
    </form>
    <br />

	Lista de lançamentos:
	<br />

	<ol>
		<c:forEach items="${lancamentos}" var="lancamento">
			<li>${lancamento.data} | ${lancamento.fornecedor.nome} | ${lancamento.tipo.valor} | ${lancamento.valor} | ${lancamento.pagamento} | ${lancamento.observacoes} |
					<a href="/contas/lancamentos/mostra?id=${lancamento.id}">Editar</a>
					<a href="/contas/lancamentos/remove?id=${lancamento.id}">Remover</a>
			</li>
		</c:forEach>
	</ol>

</body>
</html>