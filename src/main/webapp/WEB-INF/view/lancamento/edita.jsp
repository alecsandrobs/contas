<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/lancamentos" var="linkServletEditaLancamento"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<form action="${linkServletEditaLancamento}" method="post">
    Data: <input type="text" name="data" value="${ lancamento.data }"/>
    Fornecedor: <input type="text" name="fornecedor" value="${ lancamento.fornecedor.id }"/>
    Conta: <input type="text" name="conta" value="${ lancamento.conta.id }"/>
    Tipo: <input type="text" name="tipo" value="${ lancamento.tipo.valor }"/>
    Valor: <input type="text" name="valor" value="${ lancamento.valor }"/>
    Pagamento: <input type="text" name="pagamento" value="${ lancamento.pagamento }"/>
    Observações: <input type="text" name="observacoes" value="${ lancamento.observacoes }"/>
    <input type="hidden" name="id" value="${ lancamento.id }"/>
    <input type="hidden" name="acao" value="Editar"/>
    <button type="submit">Editar</button>
</form>
</body>
</html>