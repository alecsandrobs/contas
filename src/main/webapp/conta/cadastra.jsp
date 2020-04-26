<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/contas/cadastra" var="linkServletCadastraConta" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<form action="${linkServletCadastraConta}" method="post">
    Banco: <input type="text" name="banco" />
    Agência: <input type="text" name="agencia" />
    Número: <input type="text" name="numero" />
    <button type="submit">Cadastrar</button>
</form>
</body>
</html>