<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/contas" var="linkServletListaContas"/>
<c:url value="/contatos" var="linkServletListaContatos"/>
<c:url value="/fornecedores" var="linkServletListaFornecedores"/>
<c:url value="/lancamentos" var="linkServletListaLancamentos"/>
<c:url value="/obra" var="linkServletListaObra"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Contas da obra</title>
</head>
<body>
<c:import url="WEB-INF/view/logout-parcial.jsp"/>

<h2>Contas pagar e a pagar da obra</h2>
<p>
<form action="${linkServletListaObra}" method="get">
    <input type="hidden" name="acao" value="ContaListar"/>
    <button type="submit">Contas</button>
</form>
<form action="${linkServletListaObra}" method="get">
    <input type="hidden" name="acao" value="ContatoListar"/>
    <button type="submit">Contatos</button>
</form>
<form action="${linkServletListaObra}" method="get">
    <input type="hidden" name="acao" value="FornecedorListar"/>
    <button type="submit">Fornecedores</button>
</form>
<form action="${linkServletListaObra}" method="get">
    <input type="hidden" name="acao" value="LancamentoListar"/>
    <button type="submit">Lançamentos</button>
</form>
</p>
</body>
</html>
