<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/obra" var="linkServletEditaContato"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<c:import url="logout-parcial.jsp"/>

<form action="${linkServletEditaContato}" method="post">
    Nome: <input type="text" name="nome" value="${ contato.nome }"/>
    Documento: <input type="text" name="documento" value="${ contato.documento }"/>
    Telefone: <input type="text" name="telefone" value="${ contato.telefone }"/>
    E-mail: <input type="text" name="email" value="${ contato.email }"/>
    <input type="hidden" name="id" value="${ contato.id }"/>
    <input type="hidden" name="acao" value="ContatoEditar"/>
    <button type="submit">Editar</button>
</form>
</body>
</html>