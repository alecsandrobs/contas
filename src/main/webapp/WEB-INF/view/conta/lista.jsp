<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page
        import="java.util.List, com.stolk.alecsandro.contas.modelo.Conta" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/contas" var="linkServletNovaConta"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>### Lista de contas ###</title>
</head>
<body>

<c:if test="${ not empty conta }">
    Conta ${ conta } cadastrada com sucesso!
</c:if>

<br/>
<form action="${linkServletNovaConta}" method="get">
    <input type="hidden" name="acao" value="Nova"/>
    <button type="submit">Cadastrar</button>
    <a href="http://localhost:8080/contas/">voltar</a>
</form>
<br/>

Lista de contas:
<br/>

<ol>
    <c:forEach items="${contas}" var="conta">
        <li>${conta.banco} | ${conta.agencia} | ${conta.numero} |
            <a href="/contas/contas?acao=Mostrar&id=${conta.id}">Editar</a>
            <a href="/contas/contas?acao=Excluir&id=${conta.id}">Remover</a>
        </li>
    </c:forEach>
</ol>

</body>
</html>