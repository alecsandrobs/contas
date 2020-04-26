<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/contas/edita" var="linkServletEditaConta" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<form action="${linkServletEditaConta}" method="post">
    Banco: <input type="text" name="banco" value="${ conta.banco }" />
    Agência: <input type="text" name="agencia" value="${ conta.agencia }" />
    Número: <input type="text" name="numero" value="${ conta.numero }" />
    <input type="hidden" name="id" value="${ conta.id }" />
    <button type="submit">Editar</button>
</form>
</body>
</html>