<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page
        import="java.util.List, com.stolk.alecsandro.contas.modelo.Lancamento" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/obra" var="linkServletNovoLancamento"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>### Lista de lançamentos ###</title>
</head>
<body>
<c:import url="logout-parcial.jsp"/>

<c:if test="${ not empty lancamento }">
    Lançamento ${ lancamento } cadastrado com sucesso!
</c:if>

<br/>
<form action="${linkServletNovoLancamento}" method="get">
    <input type="hidden" name="acao" value="LancamentoNovo"/>
    <button type="submit">Cadastrar</button>
    <a href="http://localhost:8080/contas/">voltar</a>
</form>
<br/>

Lista de lançamentos:
<br/>

<ol>
    <c:forEach items="${lancamentos}" var="lancamento">
        <li>${lancamento.data} | ${lancamento.fornecedor.nome} | ${lancamento.tipo.valor} | ${lancamento.valor}
            | ${lancamento.pagamento} | ${lancamento.observacoes} |
            <a href="/contas/obra?acao=LancamentoMostrar&id=${lancamento.id}">Editar</a>
            <a href="/contas/obra?acao=LancamentoExcluir&id=${lancamento.id}">Remover</a>
        </li>
    </c:forEach>
</ol>

</body>
</html>