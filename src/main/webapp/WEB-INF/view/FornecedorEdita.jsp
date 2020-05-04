<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/obra" var="linkServletEditaFornecedor"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<c:import url="logout-parcial.jsp"/>

<form action="${linkServletEditaFornecedor}" method="post">
    Nome: <input type="text" name="nome" value="${ fornecedor.nome }"/>
    Documento: <input type="text" name="documento" value="${ fornecedor.documento }"/>
    <input type="hidden" name="id" value="${ fornecedor.id }"/>
    <input type="hidden" name="acao" value="FornecedorEditar"/>
    <button type="submit">Editar</button>
</form>
</body>
</html>