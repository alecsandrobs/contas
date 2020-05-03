<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page
        import="java.util.List, com.stolk.alecsandro.contas.modelo.Contato" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/contatos" var="linkServletNovoContato"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>### Lista de contatos ###</title>
</head>
<body>

<c:if test="${ not empty contato }">
    Contato ${ contato } cadastrado com sucesso!
</c:if>

<br/>
<form action="${linkServletNovoContato}" method="get">
    <input type="hidden" name="acao" value="Novo"/>
    <button type="submit">Cadastrar</button>
    <a href="http://localhost:8080/contas/">voltar</a>
</form>
<br/>

Lista de contatos:
<br/>

<ol>
    <c:forEach items="${contatos}" var="contato">
        <li>${contato.documento} | ${contato.nome} | ${contato.telefone} | ${contato.email} |
            <a href="/contas/contatos?acao=Mostrar&id=${contato.id}">Editar</a>
            <a href="/contas/contatos?acao=Excluir&id=${contato.id}">Remover</a>
        </li>
    </c:forEach>
</ol>

</body>
</html>