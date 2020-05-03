<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/contas" var="linkServletListaContas"/>
<c:url value="/contatos" var="linkServletListaContatos"/>
<c:url value="/fornecedores" var="linkServletListaFornecedores"/>
<c:url value="/lancamentos" var="linkServletListaLancamentos"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Contas da obra</title>
</head>
<body>
<h2>Contas pagar e a pagar da obra</h2>
<p>
<form action="${linkServletListaContas}" method="get">
    <input type="hidden" name="acao" value="Listar"/>
    <button type="submit">Contas</button>
</form>
<form action="${linkServletListaContatos}" method="get">
    <input type="hidden" name="acao" value="Listar"/>
    <button type="submit">Contatos</button>
</form>
<form action="${linkServletListaFornecedores}" method="get">
    <input type="hidden" name="acao" value="Listar"/>
    <button type="submit">Fornecedores</button>
</form>
<form action="${linkServletListaLancamentos}" method="get">
    <input type="hidden" name="acao" value="Listar"/>
    <button type="submit">Lançamentos</button>
</form>
</p>
</body>
</html>
