<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/obra" var="linkServletCadastraLancamento"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<c:import url="logout-parcial.jsp"/>

<form action="${linkServletCadastraLancamento}" method="post">
    Data: <input type="text" name="data"/>
    Fornecedor: <input type="text" name="fornecedor"/>
    Conta: <input type="text" name="conta"/>
    Tipo: <input type="text" name="tipo"/>
    Valor: <input type="text" name="valor"/>
    Pagamento: <input type="text" name="pagamento"/>
    Observações: <input type="text" name="observacoes"/>
    <input type="hidden" name="acao" value="LancamentoCadastrar"/>
    <button type="submit">Cadastrar</button>
</form>
</body>
</html>