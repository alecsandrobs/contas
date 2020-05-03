<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/contatos" var="linkServletCadastraContato"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<form action="${linkServletCadastraContato}" method="post">
    Nome: <input type="text" name="nome"/>
    Documento: <input type="text" name="documento"/>
    Telefone: <input type="text" name="telefone"/>
    E-mail: <input type="text" name="email"/>
    <input type="hidden" name="acao" value="Cadastrar"/>
    <button type="submit">Cadastrar</button>
</form>
</body>
</html>