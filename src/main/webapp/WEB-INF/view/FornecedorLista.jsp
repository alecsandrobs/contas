<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page
        import="java.util.List, com.stolk.alecsandro.contas.modelo.Fornecedor" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/obra" var="linkServletNovoFornecedor"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>### Lista de fornecedores ###</title>
</head>
<body>
<c:import url="logout-parcial.jsp"/>

<c:if test="${ not empty fornecedor }">
    Fornecedor ${ fornecedor } cadastrado com sucesso!
</c:if>

<br/>
<form action="${linkServletNovoFornecedor}" method="get">
    <input type="hidden" name="acao" value="FornecedorNovo"/>
    <button type="submit">Cadastrar</button>
    <a href="http://localhost:8080/contas/">voltar</a>
</form>
<br/>

Lista de fornecedores:
<br/>

<ol>
    <c:forEach items="${fornecedores}" var="fornecedor">
        <li>${fornecedor.documento} | ${fornecedor.nome} |
            <a href="/contas/obra?acao=FornecedorMostrar&id=${fornecedor.id}">Editar</a>
            <a href="/contas/obra?acao=FornecedorExcluir&id=${fornecedor.id}">Remover</a>
        </li>
    </c:forEach>
</ol>

</body>
</html>