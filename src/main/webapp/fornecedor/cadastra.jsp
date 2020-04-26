<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/fornecedores/cadastra" var="linkServletCadastraFornecedor" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<form action="${linkServletCadastraFornecedor}" method="post">
    Nome: <input type="text" name="nome" />
    Documento: <input type="text" name="documento" />
    <button type="submit">Cadastrar</button>
</form>
</body>
</html>